@ApiMethod(name = "getAllTopics", path= "getAllTopics")
    public CollectionResponse<Topic> listEvent(
            @Nullable @Named("cursor") String cursorString,
            @Nullable @Named("limit") Integer limit) {

        List<Topic> execute = //fetch from datastore

        return CollectionResponse.<Topic> builder().setItems(execute)
                .setNextPageToken(cursorString).build();
    }