public void selected(ActionEvent e)throws IOException,SQLException{

    ObservableList<Patient> selected;
    selected = tvAll.getSelectionModel().getSelectedItems();
    for (Patient patient : selected) {
        int id = patient.getId();
        // do whatever you need with id...
    }
}