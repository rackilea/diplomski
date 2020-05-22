FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindowView.fxml"));
    this.root = loader.load();

    // MainWindowController mwc = new MainWindowController();

    MainWindowController mwc = loader.getController();
    mwc.setMain(this);