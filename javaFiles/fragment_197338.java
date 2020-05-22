class Main {
  static { System.setProperty("logback.configurationFile", "/path/to/config.xml");}
  private final Logger LOG = LoggerFactory.getLogger(Main.class);

  public void main (String[] args) { ... }
}