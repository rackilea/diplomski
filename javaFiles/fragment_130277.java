String[] comments = {"Test Comment 1", "Test Comment 2"};
for(String comment : comments) {
    JsonObject newDefect = new JsonObject();
    newDefect.addProperty("Type", "ConversationPost");
    newDefect.addProperty("Text", comment);
    newDefect.addProperty("Artifact",defectReference);
    newDefect.addProperty("User", userRef);
    CreateRequest createRequest = new CreateRequest("ConversationPost", defectObject);
    CreateResponse createResponse = rallyRestAPI.create(createRequest);
}