try{
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MILESTONE WHERE NAME=?");
    preparedStatement.setString(1, name);

    System.out.println("Milestone selected with name = "+  name);
    ResultSet resultSet = preparedStatement.executeQuery();

    List<Milestone> list = new ArrayList<>();
    while(resultSet.next(){
         Milestone milestone= new Milestone();
         milestone.setId(resultSet.getString("id"));
         milestone.setName(name);
         milestone.setDescription(resultSet.getString("description"));
         list.add(milestone);
    }
}
finally{
    if(connection != null){
        try{
            connection.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
return list;