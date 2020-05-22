...
  // Get the last part of the url and remove #token
  String s = Location.getHref().substring(Location.getHref().lastIndexOf("/"));
  s = s.substring(0, s.indexOf("#")-1);
  setToken(s);
  ...

  protected native void setToken(String token) /*-{
    $wnd.history.pushState({},'', token);
}-*/;