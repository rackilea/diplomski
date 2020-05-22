@FXML
private void handleSaveNewShop(ActionEvent event) {
    String name = shopname.getText();
    String adress = streetadress.getText();
    String city = cityname.getText();
    String state = statename.getText();
    String country = countryname.getText();
    String zip = zipcode.getText();
    String phonept1 = phonecountryid.getText();
    String phonept2 = phoneareaid.getText();
    String phonept3 = phoneothernumber.getText();

    Connection conn;
    Statement stmt = null;

    try{
        Class.forName("org.sqlite.JDBC");
        System.out.print("\nConnecting to database...");
        conn = DriverManager.getConnection("jdbc:sqlite:FranchiseManagement.sqlite");
        System.out.println(" SUCCESS!\n");
        stmt = conn.createStatement();
        stmt.executeUpdate( "INSERT INTO shopList ('name','adress','city', 'state', 'country', 'zipcode', 'phonect', 'phonearea', 'phonemain') VALUES('"+name+"','"+adress+"','"+city+"','"+state+"','"+country+"','"+zip+"','"+phonept1+"','"+phonept2+"','"+phonept3+"')");
        //conn.commit();
        System.out.println(" SUCCESS!\n");
        conn.close();
    } catch (ClassNotFoundException | SQLException e){
        Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, e);
    }