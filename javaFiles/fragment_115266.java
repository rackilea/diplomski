@GET
@Path("/Classes")
@Produces("application/json")
public String feed() {
    String feeds = null;
    try {
        ArrayList<ClassList> feedData = null;
        ClassManager projectManager = new ClassManager();
        feedData = projectManager.GetFeeds();
        Gson gson_pretty = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();
        System.out.println(gson_pretty.toJson(feedData));
        feeds = gson.toJson(feedData);
    }

    catch (Exception e) {
        System.out.println("Exception Error"); // Console
    }
    return feeds;
}