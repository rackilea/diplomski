...

@Column(name = "meta_data", columnDefinition = "json")
@Convert(attributeName = "data", converter = JsonToMapConverter.class)
private Map<String, Object> metaData = new HashMap<>();

...