Stage stage = ...

// Create the WebView
BorderPane border = new BorderPane();
WebView webView = new WebView();
final WebEngine engine = webView.getEngine();
border.setCenter(webView);

Scene scene = new Scene(border);
stage.setScene(scene);
stage.show();

// Redirect the alert handler to send output to stderr
engine.setOnAlert(new EventHandler<WebEvent<String>>() {
   @Override
   public void handle(WebEvent<String> msg) {
      System.err.println(msg.getData());
   }});

// Start up the Gwt module when the page has finished loading. Grab the window
// and document objects and stash them somewhere for use later.
engine.getLoadWorker().stateProperty().addListener(
      new ChangeListener<Worker.State>() {
         @Override
         public void changed(ObservableValue<? extends State> ov,
               State oldState, State newState) {
            if (newState == Worker.State.SUCCEEDED) {
               Window win = (Window)GwtFxBridge.wrapJs(engine.executeScript("window"));

               // The web page is loaded, and you have the global window
               // JS object, so you can start your UI now
             }
         }
      });

// Load the main Gwt application web page
try {
   engine.load(new File("ui/index.html").toURI().toURL().toExternalForm());
} 
catch(MalformedURLException e)
{
   throw new IllegalArgumentException("Misconfiguration error. Cannot find empty web page", e);
}