@Override
public void initialize(URL url, ResourceBundle rb) {
    Platform.runLater(new Runnable() {
        @Override
        public void run() {
            tf.requestFocus();
        }
    });
}