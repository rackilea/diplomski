@Path("stackoverflow")
public class RomeRessource {

    @GET
    @Path("/feed")
    @Produces("application/rss+xml")
    public Response getFeed() throws IOException, FeedException {
        final SyndFeed feed = generate();

        // Write the SyndFeed to a Writer.
        final SyndFeedOutput output = new SyndFeedOutput();
        final Writer writer = new StringWriter();
        output.output(feed, writer);

        // Return a JAX-RS Response with the Writer as the body.
        return Response.ok(writer.toString()).build();
    }

    private SyndFeed generate() {
        final SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_2.0");
        feed.setTitle("My Site");
        feed.setLink("http://example.com");
        feed.setDescription("Test Site.");

        final List<SyndEntry> entries = new ArrayList<>();

        final SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("Entry1");
        entry.setLink("http://example.com/entry1");
        entry.setPublishedDate(new Date());

        final SyndContent description = new SyndContentImpl();
        description.setType("text/html");
        description.setValue("This is the content of entry 1.");

        entry.setDescription(description);

        entries.add(entry);

        feed.setEntries(entries);

        return feed;
    }
}