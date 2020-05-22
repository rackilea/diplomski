URL metafeedUrl = new URL("https://www.google.com/a/feeds/"+domain+"/user/2.0/");
System.out.println("Getting user entries...\n");
List<UserEntry> entries = new ArrayList<UserEntry>();

while (metafeedUrl != null) {
    // Fetch page
    System.out.println("Fetching page...\n");
    UserFeed resultFeed = myService.getFeed(metafeedUrl, UserFeed.class);
    entries.addAll(resultFeed.getEntries());

    // Check for next page
    Link nextLink = resultFeed.getNextLink();
    if (nextLink == null) {
        metafeedUrl = null;
    } else {
        metafeedUrl = nextLink.getHref();
    }
}

// Handle results
for(int i=0; i<entries.size(); i++) {
    UserEntry entry = entries.get(i);
    System.out.println("\t" + entry.getTitle().getPlainText());
}
System.out.println("\nTotal Entries: "+entries.size());