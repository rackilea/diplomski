SyndEntry entry = // fetched from SyndFeed
Module dcModule = entry.getModule(DCModule.URI);
String title = // My overridden title
if (dcModule != null && title != null) {
    ((DCModule)dcModule).setCreator(title);
}