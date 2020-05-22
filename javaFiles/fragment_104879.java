WebEngine engine = webView.getEngine();

    engine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
        if (newState == Worker.State.SUCCEEDED) {
            addStylesheet(engine.getDocument(), "http://page.com/style.css");
        }
    });

    engine.load(/* your html ... */);