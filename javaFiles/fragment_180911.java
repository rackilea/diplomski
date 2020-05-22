@Override
public void initialize(URL location, ResourceBundle resources){
    super.initialize();
    dao = (DAO<Employee>) dFact.getEmployeeDAO();
    try {
        employees = dao.findAll();

        // set data for the table created by the FXMLLoader
        table.setItems(employees);

        // no need to add them to the table since the FXMLLoader is ready doing that
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    } catch (SQLException e) {
        // TODO Mettre une popup erreur base de données
        e.printStackTrace();
    }

}