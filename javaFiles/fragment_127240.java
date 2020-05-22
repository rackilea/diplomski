public class SO extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pagination p = new Pagination(10);

        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            int pos = (p.getCurrentPageIndex()+1) % p.getPageCount();
            p.setCurrentPageIndex(pos);
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();

        stage.setScene(new Scene(p));
        stage.show();
    }
}