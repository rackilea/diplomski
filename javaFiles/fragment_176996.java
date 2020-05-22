public class GoogleMap {

    private DBSCANClusterer clusterer ;

    private final WebView view ;

    public GoogleMap(DBSCANClusterer c) throws MalformedURLException {
        this.clusterer = c;

        File file = new File("C:/Users/Evgeny/git/Diploma_MSU/diploma/html/map.html");
        URL url222 = file.toURI().toURL();

        view = new WebView();
        final WebEngine webEngine = webView.getEngine();

        JSObject jsobj = (JSObject) webView.getEngine()
                 .executeScript("window");
        jsobj.setMember("BrowserJavaObject", new BrowserJavaObject(clusterer));

        webEngine.load(url222.toString()); 

    } 

    public Node getView() {
        return view ;
    }

}