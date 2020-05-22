GetMappingsResponse res = client.admin().indices().getMappings(new GetMappingsRequest().indices("<index_name>")).get();
ImmutableOpenMap<String,ImmutableOpenMap<String,MappingMetaData>> mappings = res.getMappings();
System.out.println(mappings);
ImmutableOpenMap<String,MappingMetaData> mapping = mappings.get("<type_name>");
for(Iterator<MappingMetaData> iterator = mapping.valuesIt() ; iterator.hasNext();) {
    MappingMetaData metaData = iterator.next();
    System.out.println(metaData.getSourceAsMap());
}