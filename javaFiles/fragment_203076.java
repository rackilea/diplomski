class DataMetrics{
  private String min;
  private String max;
  private String avg;
  /*Insert other members*/

  private Dimensions dimensions;

  public boolean isClientSync(){
    return "Client::Sync".equals(dimensions.Name);
  }
  private class Dimensions{
    private String env;
    private String pool;
    private String Name;
  }
}