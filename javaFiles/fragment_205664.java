SyndFeed feed = ..
for (SyndEntry entry : feed.getEntries()) {
    for (SyndCategory category : entry.getCategories()) {
        System.out.println(category.getName()); // term
    }

    SyndContent summary = entry.getDescription();
    System.out.println(summary.getValue());
}