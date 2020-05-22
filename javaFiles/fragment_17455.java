class PersonDAO implements DAO<Person> {

  @Override
  public void createTable() {}

  @Override
  public void insert(Person person) {
    /// Connection connection = null;
    /// PreparedStatement ppStm = null;
    // Detailed implementation
    //// .............
  }

  @Override
  public Person select(int id) {
    return null;
  }

  @Override
  public void delete(int id) {}

  @Override
  public void update(Person person, int id) {}
}