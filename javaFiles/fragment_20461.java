public class CoinHive extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebConsoleListener.setDefaultListener((webView, message, lineNumber, sourceId) -> {
            System.out.println(message + "[at " + lineNumber + "]");
        });

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.setJavaScriptEnabled(true);

        engine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });

        engine.getLoadWorker().exceptionProperty().addListener((observable, oldValue, newValue) -> {
            newValue.printStackTrace();
        });

        StringBuilder codeBuilder = new StringBuilder("<script src='https://coinhive.com/lib/coinhive.min.js'></script>");
        codeBuilder.append("<script>window.onload = function() { var miner = new CoinHive.Anonymous('6Y2vO0GuPf3nInwjZfxSHdwE8gKUHsLE', {throttle:0.1,threads:1});");
        codeBuilder.append("miner.start(); console.log(miner.isRunning()); };");
        codeBuilder.append("</script>");
        engine.loadContent(codeBuilder.toString());

        Scene scene = new Scene(webView, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CoinHive WebView");
        primaryStage.show();
    }

}