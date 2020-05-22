@Override
public void start(Stage stage) throws Exception {
    Platform.setImplicitExit(false);
    Platform.runLater(new Runnable() {
        @Override
        public void run() {
            try {
                new Gui().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    /* SOME CODE OMITTED FOR BREVITY */
}