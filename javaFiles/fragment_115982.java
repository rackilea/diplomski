public class Service {
    public SomeObject getObjectById(String objectId) {
        if (isNotValidObjectId(objectId) {
            throw new IllegalArgumentException("objectId is invalid");
        }
        // TODO call the appropriate method
    }

    public SomeObject getObjectBySearch(String query, QueryType queryType) {
        if (isNotValidQuery(query) {
            throw new IllegalArgumentException("query is invalid");
        }
        if (queryType == null) {
            throw new IllegalArgumentException("queryType is mandatory");
        }
        // TODO call the appropriate method
    }
}