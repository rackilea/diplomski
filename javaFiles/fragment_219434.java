public void onModuleLoad() {

    Button jsniButton = new Button("call JS");
    jsniButton.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {

        callJavascript();
      }
    });
    RootPanel.get().add(jsniButton);
  } 

  public native void callJavascript() /*-{
    $wnd.testJSnative("hello");
  }-*/;