public class UserOpImpl extends GraphRepositoryImpl<User> implements UserOpCustom {

    public UserOpImpl(Neo4jOperations neo4jOperations) {
        super(User.class, neo4jOperations);
    }

/// custom interface implementations go here

}