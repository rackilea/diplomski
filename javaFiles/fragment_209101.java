if(barlist==null){
    //query=FROM Foo WHERE Id = :id
}else{
   //query=FROM Foo WHERE Id = :id AND Bar in :barlist
   // query.setParameterList(:barlist",<list object>)
}