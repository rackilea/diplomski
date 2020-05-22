class UserRepositoryImpl implements CustomUserRepository {

  private final MongoOperations operations;

  @Autowired
  public UserRepositoryImpl(MongoOperations operations) {

    Assert.notNull(operations, "MongoOperations must not be null!");
    this.operations = operations;
  }

  public List<User> yourCustomMethod() {
    // custom implementation here
  }
}