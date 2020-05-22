public class BsonMatcher implements ArgumentMatcher<Bson> {

    private BsonDocument left;

    public BsonMatcher(Bson left) {
        this.left = left.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry());
    }

    @Override
    public boolean matches(Bson right) {
        // compare as BsonDocument, since this does provide an equals()
        return left.equals(right.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
    }
}