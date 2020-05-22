String query = "match(t:TAG)<-[children:CHILD_OF]-(subtag:TAG) where t.name={name} "+
               "return t.name as parent, collect(subtag.name) as children";
for(Map row : Neo4j.queryLagData(query, singletonMap("name","brand"))) {
    String parent = (String)row.get("parent");
    List<String> children = (List<String>)row.get("children");
}