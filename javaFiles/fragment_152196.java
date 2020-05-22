public class WebEngineTest extends Application {

    private Map<Integer, Ref> refMap;
    private Method volumeMethod;

    @Override
    @SuppressWarnings("unchecked")
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load("https://www.youtube.com/watch?v=hRAZBSoAsgs");

        Field refMapField = WCGraphicsManager.class.getDeclaredField("refMap");
        refMapField.setAccessible(true);

        volumeMethod = WCMediaPlayer.class.getDeclaredMethod("setVolume", float.class);
        volumeMethod.setAccessible(true);

        WCGraphicsManager graphicsManager = WCGraphicsManager.getGraphicsManager();
        refMap = (Map<Integer, Ref>) refMapField.get(graphicsManager);

        Button button = new Button("Volume");
        button.setOnAction(event -> setVolume(0.1f));

        Group group = new Group();
        group.getChildren().addAll(webView, button);

        Scene scene = new Scene(group, 625, 625);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setVolume(float volume) {
        Collection<WCMediaPlayer> mediaPlayers = this.getMediaPlayers();
        mediaPlayers.forEach(mediaPlayer -> setVolumeMethod(mediaPlayer, volume));
    }

    private void setVolumeMethod(Object instance, Object... args) {
        try {
            volumeMethod.invoke(instance, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Collection<WCMediaPlayer> getMediaPlayers() {
        return refMap.values().stream()
                .filter(ref -> ref instanceof WCMediaPlayer)
                .map(ref -> (WCMediaPlayer) ref)
                .collect(Collectors.toList());
    }

}