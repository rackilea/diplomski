List<SearchResultEntry> searchEntries = searchResult.getSearchEntries();
 if (searchEntries.size() != 1)
 {
   // The search didn't match exactly one entry.
 }
 else
 {
   SearchResultEntry entry = searchEntries.get(0);
   result = entry.getDN();
 }