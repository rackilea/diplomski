@FXML
void addButton(ActionEvent actionEvent) {
    String contractor = tfContractor.getText();
    String natureOfContract = tfNatureOfContract.getText();
    String user_dept = tfUser_dept.getText();
    Integer value = Integer.parseInt(tfValue.getText());
    Integer valueRate = Integer.parseInt(tfValueRate.getText());
    LocalDate start_date = startDatePicker.getValue();
    //====== You need to add the end date here =====//
    LocalDate end_date = changeEndDateProperty();
    Integer contractDuration = Integer.parseInt(tfContractDuration.getText());
    String contractType = choiceBox.getValue();
    String remarks = tfremarks.getText();

    //====== You need to add the end date to the line below, and modify ActiveContractor to receive the extra end_date variable =====//
    ActiveContractor activeContractor = new ActiveContractor(contractor, natureOfContract, user_dept, value, valueRate, start_date, end_date, contractDuration, remarks, contractType);