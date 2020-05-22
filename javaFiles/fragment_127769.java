//Some service class registered with GraphQLSchemaBuilder
@GraphQLApi
public class UserService {

    @GraphQLQuery
    public List<Review> getReviews(@GraphQLContext User user) {
        return ...; //somehow get the review for this user
    }
}