VBox mon_routes = new VBox(); //You never create the VBox. This leads to a null pointer exception.

@Override
public void initialize(URL url, ResourceBundle rb) {
    // TODO
    PreparedStatement pr;
    ResultSet rs;
    String sql = "SELECT * FROM routes";

    try {
        pr = this.connection.prepareStatement(sql);
        rs = pr.executeQuery();

        List<HBox> r = new ArrayList();//Avoid Arrays. Use List instead.

        while (rs.next()) {
            HBox tempHBox = new HBox();//Create an HBox to store into the List or Array if you continue to use the Array.
            tempHBox.getChildren().add(new CheckBox(rs.getString(0)));//You never retrieve anything from the result set. <- rs.getSomething(). Add the CheckBox to the HBox
            tempHBox.getChildren().add(new CheckBox(rs.getString(1)));//You never retrieve anything from the result set. <- rs.getSomething(). Add the CheckBox to the HBox
            tempHBox.getChildren().add(new CheckBox(rs.getString(2)));//You never retrieve anything from the result set. <- rs.getSomething(). Add the CheckBox to the HBox
            r.add(tempHBox);//Add the HBox to the List
        }

        mon_routes.getChildren().addAll(r);//Add the List of HBox to the VBox.
    } catch (SQLException e1) {
        e1.printStackTrace();
    }
}