class ConfigImpl implements Config {
  private final Map<String,String> propMap;
  @Inject                                         // mandatory since you use a non-default constructor
  public ConfigImpl(Map<String,String> propMap) { // add the generic type of the map
    this.propMap = propMap;
  }
}