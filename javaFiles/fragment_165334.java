public class Toggles extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vBox = new VBox();
        for (int i = 0; i < 20; i++) {
            ToggleButton tb = new ToggleButton("ToggleButton" + i);
            tb.setUserData("UserData" + i);
            tb.selectedProperty().addListener(new ToggleButtonSourcedChangeListener(tb));
            vBox.getChildren().add(tb);
        }

        Scene scene = new Scene(new BorderPane(vBox), 320, 240);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private abstract static class SourcedChangeListener<T extends Node> implements ChangeListener<Boolean> {
        T source;

        SourcedChangeListener(T source) {
            this.source = source;
        }
    }

    private static class ToggleButtonSourcedChangeListener extends SourcedChangeListener<ToggleButton> {

        ToggleButtonSourcedChangeListener(ToggleButton source) {
            super(source);
        }

        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            System.out.println(source.getText() + " - Selected: " + source.isSelected()
                    + "; UserData: " + source.getUserData());
        }
    }
}