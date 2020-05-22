public void comboSelect2() throws IOException {
    if("Current Ratio".equals(ChoiceBox2.getSelectionModel().getSelectedItem())){

       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Tab2FXML.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           ChoiceBox2.getScene().setRoot(root1);
    }
}