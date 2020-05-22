if(resultset.next() == false{
    System.out.println("table is empty")
    statement.executeUpdate(" INSERT INTO table VALUES ('value') ");
} else {
  do  {
    idfromdb = resultset.getString("value")
    if(! idfromdb = id){
        System.out.println("no similar data has been found");
    }

    else{
        System.out.println("similar data has been found");
    }
  } while(resultset.next());
}