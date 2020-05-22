class MySqlOrganization {
  private final Organization;
  @Cacheable
  public int size() {
    // count in MySQL
  }
  @Cacheable.FlushBefore
  public void add(Employee emp) {
    // save it to MySQL
  }
}