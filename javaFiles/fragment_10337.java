public class Data {
  private List<String> database = new ArrayList();
  private List<String> kafka = new ArrayList();

  public List<String> getDatabase() {
    return database;
  }

  public void setDatabase(List<String> database) {
    this.database = database;
  }

  public List<String> getKafka() {
    return kafka;
  }

  public void setKafka(List<String> kafka) {
    this.kafka = kafka;
  }
}