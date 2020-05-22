interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    @Query(value="{ 'email' : ?0 }", fields="{ 'firstName' : 1, 'lastName' : 1}")
    UserShort findUserShortByEmail(String email);
}