try
{
    Statement statement = connection.createStatement();
    statement.executeUpdate(insert);
    connection.commit(); // <====== Here
    System.out.println("Inserted record in the table");
}catch(SQLException e)
{
    System.out.println("Error due to SQL Exception");
    e.printStackTrace();
}