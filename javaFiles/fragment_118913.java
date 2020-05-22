@MyConfig
class MyConfiguration {
  public MyConfiguration() {
    // note this is potentially dangerous, as this isn't finished constructing
    // yet so be very cautious of this pattern, even though it might seem cleaner
    annotationMap.put(MyConfig.class, this);
  }
}