public final static Map<String, Object> pojo2Map(Object obj) {
    Map<String, Object> hashMap = new HashMap<String, Object>();
    try {
        Class<? extends Object> c = obj.getClass();
        Method m[] = c.getMethods();
        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().indexOf("get") == 0) {
                String name = m[i].getName().toLowerCase().substring(3, 4) + m[i].getName().substring(4);
                hashMap.put(name, m[i].invoke(obj, new Object[0]));
            }
        }
    } catch (Throwable e) {
        //log error
    }
    return hashMap;
}