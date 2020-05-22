class DataReader implements Runnable {
    private final DataSource dataSource;

    public DataReader(String location) {
        dataSource = new DataSource(location);

        Thread thread = new Thread(this);
        thread.setDaemon(false);
        thread.start();
    }

    public void run() {
        while (dataSource.hasData()) {
            MyImmutableObject newData = dataSource.getSomeData();
            Platform.runLater(() -> MyApplication.changeScene(newData));
        }
    }
}

class MyApplication extends Application {
    public void changeScene(MyImmutableObject newData) {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
               "layout.fxml"
            )
        );

        UIController controller = 
            loader.<UIController>getController();
        controller.initData(newData);

        Scene scene = new Scene((Pane) loader.load());
        stage.setScene(newScene);
    }
}