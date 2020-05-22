public enum BestemmingBad implements Bestemming {
  TEST("test"), TEST2("test2");
  private final String value;
  BestemmingBad(String value) { this.value = value; }
  public String getValue() { return value; }
}

public class UrlGetter {
  private String jmsServer;
  @Inject UrlGetter(MyEnvironmentConfig config) {
    jmsServer = config.retrieveJsmServerName();
  }
  public String getUrl(Bestemming bestemming) { // or BestemmingBad
    return jmsServer + "/" + bestemming.getValue();
  }
}