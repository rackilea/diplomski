// Utilizes "Singleton" pattern
class GmailConfiguration {
  private static final GmailConfiguration INSTANCE = new GmailConfiguration();

  boolean isConfigured;
  String host;
  String port;
  //etc.

  public void configure() {
    if (!isConfigured) {
      // read in the properties, populate host/port etc.
      isConfigured = true;
    }
    // when called for the second time, reading won't happen
  }
}