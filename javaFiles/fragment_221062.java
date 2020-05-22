store.getConventions().setFindCollectionName(clazz -> {
    if (Category.class.isAssignableFrom(clazz)) {
        return "ProductGroups";
    }

    return DocumentConventions.defaultGetCollectionName(clazz);
});