public void foo(ArrayList<Date> dateList) {
    if(dateList == null)
        return;

    PreparedStatement stmt = null;
    ResultSet rs = null;    
    java.sql.Date sDate = null;
    StringBuilder builder = new StringBuilder();

    try{
        //1. Create your dynamic statement
        builder.append("SELECT * FROM some_table p WHERE \n");
        for(int index = 0; index < dateList.length; index++){
            if(index > 0)
                builder.append(" OR \n");
            builder.append("(p.start_date <=? and ?<= p.end_date)");
        }

        stmt = getConnection().preparedStatement(builder.toString());

        //2. Set the parameters
        int index = 1;
        for(Date date: dateList){
            try{
                sDate = new java.sql.Date(date.getTime());
                stmt.setDate(index, sDate);
                stmt.setDate(index+1, sDate);
                index += 2;
            }finally{
                sDate = null;
                //mange your resultset closing
            }
        }

        //3. execute your query
        rs = stmt.executeQuery();

        //4. perform your operations
    }finally{
        builder = null;
        //your resource management code
    }

}