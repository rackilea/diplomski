public class Viewer extends Application {

        @Override 
        public void start(Stage stage) {
          // load the image
          Image image = new Image("file:" + getParameters().getNamed().get("file"));
          ...
        }

        public void caller(String[] args) {
            launch(args);
        }

        /**
         * This is a example of the passing a parameters 
         * @param args the command line arguments
         */
        public static void main(String[] args) {
             (new Viewer()).caller(new String[]{"--file=path/to/file.jpg"});
        }

    }