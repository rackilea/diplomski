public List<T> findByExample(T example, Map<String, SortOrder> sortMap, int startIndex, int pageSize) throws DAOException {
    try {
        Object object = example;
        String query = "SELECT e from " + object.getClass().getName() + " e where 1 = 1";
        if(!(object instanceof BaseEntity))
        {
            throw new DAOException(null, null);
        }
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object fieldValue;
            field.setAccessible(true);
            if (field.get(object) instanceof List || (java.lang.reflect.Modifier.isStatic(field.getModifiers())) || field.getName().startsWith("_")) {
                continue;
            } else {
                fieldValue = field.get(object);
                if (fieldValue != null) {
                    if ((fieldValue instanceof String) && !((String) fieldValue).isEmpty()) {
                        query += " and e." + field.getName() + " LIKE :" + field.getName();
                    } else {
                        query += " and e." + field.getName() + " = :" + field.getName();
                    }
                }
            }
        }
        if(sortMap != null && !sortMap.isEmpty())
        {
            for(Entry<String, SortOrder> entry : sortMap.entrySet())
            {
                query += " ORDER BY e." + entry.getKey() + " " + entry.getValue().name();
            }
        }
        Query q = em.createQuery(query, object.getClass());

        for (Field field : fields) {
            Object fieldValue;
            field.setAccessible(true);
            if (field.get(object) instanceof List || (java.lang.reflect.Modifier.isStatic(field.getModifiers())) || field.getName().startsWith("_")) {
                continue;
            } else {
                fieldValue = field.get(object);
                if (fieldValue != null) {
                    if ((fieldValue instanceof String) && !((String) fieldValue).isEmpty()) {
                        q.setParameter(field.getName(), "%" + field.get(object) + "%");
                    } else {
                        q.setParameter(field.getName(), field.get(object));
                    }
                }
            }
        }
        return q.setFirstResult(startIndex).setMaxResults(pageSize).getResultList();

    } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {

        throw new DAOException(null, e);
    }
}