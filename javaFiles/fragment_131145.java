public static <T extends Dao<T>> List<T> get(Class<T> classType, Query q){ 

    List<T> list = new ArrayList<>(); 

    try { 
        List<Map<String, Object>> results = Model.getAll(q); 

        for (Map<String, Object> map : results) { 
            T obj = (T) PojoFactory.createPojo(classType.getSimpleName()); 
            for (String key : map.keySet()) { 
                //Double check if field names exist before setting them 

                //http://commons.apache.org/proper/commons-beanutils/
                BeanUtils.setProperty(obj, key, map.get(key)); 
            } 
            list.add(obj); 
        } 

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } 

    return list; 
}