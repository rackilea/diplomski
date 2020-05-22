private static DataBaseConnectionDAO databaseConnection;

    private static java.sql.Connection getDatabaseConnection() {
        if (databaseConnection == null) {
            databaseConnection = DataBaseConnectionDAO.getInstance();
        }
        return databaseConnection.getConnection();
    }

    public static HSSFWorkbook getWorkbook(HSSFWorkbook workbook, Long id, Environment env){

     try{

         java.sql.Connection conn = getDatabaseConnection();
         // ...