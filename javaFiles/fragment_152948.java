GetMappingsResponse response = client()
        .admin()
        .indices()
        .prepareGetMappings()
        .execute()
        .actionGet();

    ImmutableOpenMap<String, ImmutableOpenMap<String, MappingMetaData>> mappings = response.getMappings();

    ...