// data = new HashMap<>();
ExpandSelectTreeNode node = ExpandSelectTreeNode.entitySet(entitySet)
    .selectedProperties(new ArrayList<String>(data.keySet())).build();

EntityProviderWriteProperties properties = EntityProviderWriteProperties
            .serviceRoot(rootUri).omitJsonWrapper(true).contentOnly(true)
            .expandSelectTree(node)
            .build();

// serialize data into ODataResponse object
ODataResponse response = EntityProvider.writeEntry(contentType,
        entitySet, data, properties);