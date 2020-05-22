SearchResult<issue> issues=db.search("attributes/by_name_value")
    .limit(10).includeDocs(false)
    .querySearchResult("name:\"web*\"", issue.class);

for (int i = 0; i < issues.getRows().size(); i++) {
    SearchResult<issue>.SearchResultRow row = issues.getRows().get(i);
    System.out.println(row.getId());
    System.out.println(row.getFields().getName());             
    System.out.println(row.getFields().getValue());
}