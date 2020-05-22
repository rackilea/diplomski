public class TestFrame extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        File actualFile = new File("shelter.mov");
        File emptyfile = new File("blank.mp4");
        Media media = new Media(emptyfile.toURI().toString());
        copyData(media, actualFile);
        MediaPlayer mediaPlayer = null;
        try {
            mediaPlayer = new MediaPlayer(media);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer);
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root, 720, 480);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void copyData(Media media, File f) {
        try {
            Field locatorField = media.getClass().getDeclaredField("jfxLocator");
            // Inside block credits:
            // http://stackoverflow.com/questions/3301635/change-private-static-final-field-using-java-reflection
            {
                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(locatorField, locatorField.getModifiers() & ~Modifier.FINAL);
                locatorField.setAccessible(true);
            }
            CustomLocator customLocator = new CustomLocator(f.toURI());
            customLocator.init();
            customLocator.hack("video/mp4", 100000, f.toURI());
            locatorField.set(media, customLocator);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    static class CustomLocator extends Locator {
        public CustomLocator(URI uri) throws URISyntaxException {
            super(uri);
        }

        @Override
        public void init() {
            try {
                super.init();
            } catch (Exception e) {
            }
        }

        public void hack(String type, long length, URI uri){
            this.contentType = type;
            this.contentLength = length;
            this.uri = uri;
            this.cacheMedia();
        }
    }
}