public <T> void find(Class clazz, List<String> fieldsToBeUpdated) {
    List<T> collectionList = db.findAll((Class<T>) clazz);
    if (CollectionUtils.isNotEmpty(collectionList)) {
        collectionList.stream().forEach(p -> {
            fieldsToBeUpdated.stream().forEach(field -> {
            Date date = null;
                try {
                 if (null != clazz.getDeclaredField(field)) {
                        Field f = clazz.getDeclaredField(field);
                        f.setAccessible(true);
                        date = (Date) f.get(p);
                    }
                } catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException e) {
                    e.printStackTrace();
                } 
            });
        });
    }
}