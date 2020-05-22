//I will assume that your values (data to be inserted) is a List of Object types and that it is already populated



List<Object> data = new ArrayList<>();
    //you will populate this list

    //getting the column names
    List<String> columnNames = getColumns("MyTable", "MyDB");

    String insertColumns = ""; 
    String insertValues = "";

    if(columnNames != null && columnNames.size() > 0){
        insertColumns += columnNames.get(0);
        insertValues += "?";
    }


    for(int i = 1; i < columnNames.size();i++){
      insertColumns += ", " + columnNames.get(i) ;
      insertValues += "?";
    }

    String insertSql = "INSERT INTO MyDB.MyTable (" + insertColumns + ") values(" + insertValues + ")"; 

    try{
    PrepareStatement ps = conn.prepareStatement(insertSql);

    for(Object o : data){
     ps.setObject(o); //you must pass objects of correct type
    }
    ps.execute(); //this inserts your data
    }catch(SQLException sqle){
      //do something with it
    }