ObjectMapper mapper = new ObjectMapper();

// add module for meta data permissions
SimpleModule module = new SimpleModule("IncludeMetaData", new Version(0, 1, 0, "alpha"));
module.addSerializer(MetaClass.class, new MetaDataSerializer(permissions, p instanceof AbstractBean ? ((AbstractBean) p).isOwner() : false));
mapper.registerModule(module);

// ignore missing filters
mapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));

return mapper.writerWithView(Views.Admin.class).writeValueAsString(p)