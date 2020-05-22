private WebView webView;
private WebEngine engine;

private void createCalendar() {
    webView = new WebView();
    engine = webView.getEngine();
    engine.load("file:D:/standAloneDev//src/fc/fullcalendarwebview/fullcalendar-1.6.4/demos/selectable.html");

    engine.getLoadWorker().stateProperty().addListener((ov,oldState, newState)->{
        if(newState==State.SUCCEEDED){

            // JS to Java
            JSObject script = (JSObject) engine.executeScript("window");
            script.setMember("myClick", new JavaApp());

            // Java to JS
            engine.executeScript("function testCheckMate() {\n" +
                        "            alert(\"Check-Mate\");\n" +
                        "        };");
        }
    });

    engine.setOnAlert(e->System.out.println("Alert: "+e.getData()));
}