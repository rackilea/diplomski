preparedStatement = conn.prepareStement("select * from people");

resultSet = preparedStatement.executeQuery();

//copying the value
while(resultSet.hasNext()){
    String name = resultSet.getString("name");
    String surname = resultSet.getString("surname");

    //Person is a class of your own
    Person person = new Person(name,surname); 

    //people is a Collection of Person created outside this loop
    people.add(person); 
}