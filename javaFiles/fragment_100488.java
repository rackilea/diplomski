public class AppOne extends Application
{
    @Override
    public void start(Stage stage)
    {
        Scene scene = new Scene(new Group(new Label("Hello from AppOne")), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        System.out.println("Starting first app");
        Platform.runLater(() -> {
            new AppOne().start(new Stage());
        });
        System.out.println("Starting second app");
        Platform.runLater(() -> {
            new AppTwo().start(new Stage());
        });
    }
}

public class AppTwo extends Application
{
    @Override
    public void start(Stage stage)
    {
        Scene scene = new Scene(new Group(new Label("Hello from AppTwo")), 600, 400);
        stage.setScene(scene);
        stage.show();
    }    
}