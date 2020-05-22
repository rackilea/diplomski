boolean created;
try {
    q = "CREATE TABLE ...";
    Statement st = connection.createStatement();

    //you can use
    System.out.println(st.executeUpdate(q));
    //or 
    System.out.println(st.execute(q));

    created = true;
} catch (SQLException e) {
    created = false;
}

//now you can check if your table is created or not
if(created){
    System.out.println("Table created with sucess");
}else{
    System.out.println("Faild to create table");
}