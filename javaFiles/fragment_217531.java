@FXML
void acttable(ActionEvent event) {

String sqlQuery = "SELECT * FROM restauranttables;";
List<Button> buttonlist = new ArrayList<>(); //our Collection to hold newly created Buttons
try {
    connection = database.getConnection();
    statement = connection.createStatement();
    resultSet = statement.executeQuery(sqlQuery);
    while (resultSet.next()) { //iterate over every row returned
        String restaurant = resultSet.getString("restaurantname"); //extract button text, adapt the String to the columnname that you are interested in
        buttonlist.add(new Button(restaurant));

    }
    hboxx.getChildren().clear(); //remove all Buttons that are currently in the container
    hboxx.getChildren().addAll(buttonlist); //then add all your Buttons that you just created

} catch (SQLException e) {
    e.printStackTrace();
} finally{
    resultSet.close();
    statement.close();
    connection.close;
}
}