private void showTab() {
    try {
        // Tab 1 loader
        FXMLLoader loaderTab1 = new FXMLLoader(Main.class.getResource("Tab1.fxml"));
        // Tab 2 loader
        FXMLLoader loaderTab2 = new FXMLLoader(Main.class.getResource("Tab2.fxml"));

        TabPane tabPane = new TabPane();

        // Remove the 4 following lines, Tabs are already declared in FXML
        //Tab tab1 = new Tab();
        //Tab tab2 = new Tab();
        //tab1.setContent(loaderTab1.load());
        //tab2.setContent(loaderTab2.load());
        Tab tab1 = loaderTab1.load();
        Tab tab2 = loaderTab2.load();

        tabPane.getTabs().addAll(tab1,tab2);

        rootLayout.setCenter(tabPane);

    } catch (IOException e){
        e.printStackTrace();
    }
}