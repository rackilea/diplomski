public class CustomTextControl {

    private static class BooleanWrapper {
        private boolean value ;
    }

    public static <T extends TextInputControl> T customize(T control) {

        BooleanWrapper recentlyFocused = new BooleanWrapper();

        control.addEventFilter(MouseEvent.MOUSE_DRAGGED, event -> {
            if (recentlyFocused.value) {
                event.consume();
            }
        });

        control.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            // Deselect on focus loss
            if (!newValue) {
                control.deselect();
                recentlyFocused.value = false;
                return;
            }
            recentlyFocused.value = true;
            // Select all
            Platform.runLater(() -> {
                if (!control.getText().isEmpty()) {
                    control.selectAll();
                }
            });

            // Delay to avoid issues
            Timeline tl = new Timeline(new KeyFrame(Duration.seconds(0.2), event -> recentlyFocused.value = false));
            tl.play();
        });

        return control ;
    }

}