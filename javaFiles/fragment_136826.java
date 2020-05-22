public class Main extends Application {

    private final ObjectProperty<ToggleButton> rememberMe = new SimpleObjectProperty<>();
    private final List<ToggleButton> buttons = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(5));

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                ToggleButton button = new ToggleButton(row + " | " + col);

                button.selectedProperty().addListener((w, o, n) -> {
                    if (n) {
                        if(rememberMe.get() != null) {
                            turn(rememberMe.get() , button);
                        }
                        else {
                            rememberMe.set(button);
                        }
                    }
                });
                grid.add(button, col, row);
                buttons.add(button);
            }
        }

        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void turn(ToggleButton pButton1, ToggleButton pButton2) {
        rememberMe.set(null);

        System.out.println(pButton1 + " - " + pButton2);

        buttons.forEach(tb -> tb.setSelected(false));
    }

    public static void main(String[] args) {
        launch(args);
    }
}