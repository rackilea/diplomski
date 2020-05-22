public <T extends RealmObject> List<T> searchDatabase(Class<T> clazz, String searchQuery) {

    RealmQuery<T> query = realmDatabase.where(clazz).beginGroup();

    Field[] fields = clazz.getDeclaredFields();

    for (int i = 0; i < fields.length; i++) {
        Class<?> type = fields[i].getType();
        String fieldName = fields[i].getName();

        if (i > 0) {
            query.or()
        }   

        if (type.equals(String.class)) {
            query.contains(fieldName, searchQuery)
        } else if (type.equals(Integer.class)) {
            query.equalTo(fieldName, Integer.parseInt(searchQuery))
        } else {
            ...
        }
    }

    /* Return All Objects Found */
    return query.endGroup().findAll();
}