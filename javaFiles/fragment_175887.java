LoadingCache<Class<?>, String> tableNames = CacheBuilder.newBuilder()
       .weakKeys()
       .build(
           new CacheLoader<Class<?>, String>() {
             public String load(Class<?> key) {
                 Table table = objClass.getAnnotation(Table.class);
                 return table == null ? key.getSimpleName() : table.name();
             }
           });