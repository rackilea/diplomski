public void OnModuleLoad() {
     if (isMyJsLibLoaded() == false) {
        ScriptInjector.fromUrl("myjslib.js").inject();
     }
  }

  private native boolean isMyJsLibLoaded() /*-{
     return !!$wnd.myjslib;
  }-*/;