public void preUpdateWithChanges(DescriptorEvent event) {
    if (event.getQuery() instanceof UpdateObjectQuery) {
        UpdateObjectQuery query = (UpdateObjectQuery) event.getQuery();
        for (ChangeRecord cr : query.getObjectChangeSet().getChanges()) {
            String clazz = query.getObject().getClass().getSimpleName();
            Object id = query.getObjectChangeSet().getId();
            Object newValue = PropertyUtils.getProperty(query.getObject(), cr.getAttribute());
            Object oldVal = cr.getOldValue();
    }
}