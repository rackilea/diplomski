SearchResponse response = client.prepareSearch("contact").get();
ObjectMapper mapper = new ObjectMapper();
List<Contact> lst = new ArrayList<Contact>();
for(SearchHit hit : response.getHits().getHits()) {
    Contact c = mapper.readValue(hit.getSourceAsString(), Contact.class);
    lst.add(c);
}