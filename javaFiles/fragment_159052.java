public void foo(ArrayList<Date> dateList) {
    if(dateList == null)
        return;

    PreparedStatement stmt = null;
    ResultSet rs = null;    
    java.sql.Date sDate = null;
    try{
        stmt = getConnection().preparedStatement("select * from some_table p where p.start_date <=? and ?<= p.end_date");

        for(Date date: dateList){
            try{
                sDate = new java.sql.Date(date.getTime());
                stmt.clearParameters(); //Clear current parameter values
                stmt.setDate(1, sDate);
                stmt.setDate(2, sDate);
                rs = stmt.executeQuery();

                //perform your operations
            }finally{
                sDate = null;
                //mange your resultset closing
            }
        }
    }finally{
        //your resource management code
    }  
}