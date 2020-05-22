private static class MyObject {

  private final String name;
  private final Date date;

  private MyObject(String name, Date date) {
    this.name = name;
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public Date getDate() {
    return date;
  }
}