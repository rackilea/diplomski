public Browser(String page, AppHandle handle) {
  browser.setFontSmoothingType(FontSmoothingType.GRAY);
  browser.setContextMenuEnabled(false);

  webEngine.getLoadWorker().stateProperty()
    .addListener(
      new ChangeListener<State>() {
        @Override
        public void changed(ObservableValue<? extends State> ov, 
            State oldState, State newState) { 
          if (newState == State.SUCCEEDED) {
            JSObject win = (JSObject) webEngine.executeScript("window");
            win.setMember("app", handle);
          }
        }
      }
    );
  webEngine.load(page);
  getChildren().add(browser);
}