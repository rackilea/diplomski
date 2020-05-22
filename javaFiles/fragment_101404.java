Set<String> dups = new HashSet<> ();
for(Feeds f : mFeeds) {
    if (dups.contains(f.getDate())
        f.setDate(null); // this date already appeared in the list, so set it to null
    else
        dups.add(f.getDate()); // this is the first occurrence of this date
}