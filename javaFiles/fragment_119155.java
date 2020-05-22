private void showMainStage() throws IOException {
    final Info i1 = new Info("1");
    i1.setPosition(1);
    i1.setTitle("Info 1");
    final Info i2 = new Info("2");
    i2.setPosition(2);
    i2.setTitle("Info 2");
    final List<Info> infoList = new ArrayList<>();
    infoList.add(i1);
    infoList.add(i2);

    final FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/fxml/Main.fxml"));
    final Parent root = loader.load();
    ((MainController)loader.getController()).updateTable(infoList);
    ...


//    final FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/fxml/InfoTable.fxml"));
    ...
}