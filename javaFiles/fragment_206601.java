private native Element open(String url, String name, String features) /*-{
    return $wnd.open(url, name, features);
  }-*/;

  private native boolean isOpen(Element win) /*-{
    return !! (win && !win.closed);
  }-*/;

  private native void close(Element win) /*-{
    if (win) win.close();
  }-*/;

  private native void focus(Element win) /*-{
    if (win) win.focus();
  }-*/;

  private Element win = null;

  public void onModuleLoad() {

    Button open = new Button("Open Win");
    Button close = new Button("Close Win");
    RootPanel.get().add(open);
    RootPanel.get().add(close);


    open.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (!isOpen(win)) {
          win = open("http://www.google.com", "myWin", "height=600,width=800,scrollbars=yes,resizable=yes,toolbar=no,directories=no,status=no,menubar=no");
        }
        focus(win);
      }
    });

    close.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        close(win);
      }
    });

  }