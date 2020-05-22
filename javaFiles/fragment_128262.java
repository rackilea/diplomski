ArrayList<String> arr = new ArrayList<String>() ;
rs = statement.executeQuery(); // that is the select statement 
//Select * FROM table_name WHERE column1 like %VALUE%' OR column2 like %VALUE% and other columns like this too...
List<String> cols = Arrays.asList(getColLabels());
// I am getting Column Labels from ResultSetMetaData and it works fine  
while(rs.next()){
    for(String column: cols){
        String value;               
        if(rs.getObject(column) != null){    

            if((value = rs.getObject(column).toString()).matches(".*"+searchedVal+".*") ){
        //searchedVal is searched value 
                arr.add("UPDATE Table_Name SET "+column+" ='"+newValue+"' WHERE "+ column+" ='" +value+"';"  );
                // then send array in another function to update to database
                break;
            }
        }
    }
}