class PlugInRegistry {
  @Inject
  public PlugInRegistry(Map<String, PlugIn> plugins) {
    PlugIn optional = plugins.get("Optional");
    if(optional == null) {
        // do what you're supposed to do if the plugin doesn't exist
    }
  }
}