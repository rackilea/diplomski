webEngine.getLoadWorker().stateProperty().addListener(
    new ChangeListener<Worker.State>() {
        @Override
        public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
            if (newValue == Worker.State.SUCCEEDED) {
                JSObject windowObject = (JSObject) webEngine.executeScript("window");
                windowObject.setMember("Debug", debug); // insert object
                windowObject.call("ready"); // execute callback
            }
        }
    }
);