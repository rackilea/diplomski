public final void readFile(final String path)
        throws IOException, SQLException, InterruptedException {
    File file = new File(path);

    final Connection connection = getSqlDataSource().getConnection();
    Statement statement = SqlDataSource.getInternalStatement(connection.createStatement());

    try{
        Scanner fileScanner = new Scanner(file);
        fileScanner.useDelimiter(Pattern.compile("^$", Pattern.MULTILINE));

        while(fileScanner.hasNext()){
            String line;
            while ((line = fileScanner.nextLine()).isEmpty());

            InputStream is = new ByteArrayInputStream(fileScanner.next().getBytes("UTF-8"));
            String [] tableName = line.split(getSeparator());
            setTable((tableName[0]+"_"+tableName[1]).replace('-', '_'));

            String sql = "LOAD DATA LOCAL INFILE '" + SingleCsvImportBean.getOsDependantFileName(file) + "' " 
                    + "INTO TABLE " + SqlUtils.escape(getTable()) 
                    + "FIELDS TERMINATED BY '" + getSeparator() 
                    + "' ESCAPED BY '' LINES TERMINATED BY '" + getLinefeed() + "' ";
            sql += "(" + implodeStringArray(getFields(), ", ") + ")";       
            sql += getSetClause();

            ((com.mysql.jdbc.Statement) statement).setLocalInfileInputStream(is);
            statement.execute(sql);         
        }
    }finally{
        statement.close();
        connection.close();
    }   
}