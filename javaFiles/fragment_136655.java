public class Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String s = "some times there are\nmore strings\n\nin here";
        TextArea ta = new TextArea(s);
        ta.setSkin(new TextAreaMaskSkin(ta));

        TextArea view = new TextArea();
        view.textProperty().bind(ta.textProperty());

        Scene scene = new Scene(new HBox(view, ta));
        stage.setScene(scene);
        stage.show();
    }

    private static class TextAreaMaskSkin extends TextAreaSkin {

        public TextAreaMaskSkin(TextArea textArea) throws Exception {
            super(textArea);
            Field field = TextAreaSkin.class.getDeclaredField("paragraphNodes");
            field.setAccessible(true);
            Group group = (Group) field.get(this);
            Text text = (Text) group.getChildren().get(0);
            text.setText(maskText(textArea.textProperty().getValueSafe()));
            text.textProperty().addListener(o -> text.setText(maskText(textArea.textProperty().getValueSafe())));
        }

        @Override
        protected String maskText(String txt) {
            int n = txt.length();
            StringBuilder passwordBuilder = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                if (txt.charAt(i) == '\n') {
                    passwordBuilder.append('\n');
                } else {
                    passwordBuilder.append(TextFieldSkin.BULLET);
                }
            }
            return passwordBuilder.toString();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}