class Migrator {
  public static void main(String[] args) throws Exception {
    ...
    Flyway flyway = new Flyway();
    flyway.setDataSource(url, user, password);
    flyway.migrate();
  }
}