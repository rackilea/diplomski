private Map<String, IRule> rules = Maps.newHashMap();

public static <T extends IRule> T getRuleInstance(String clazz) {
    try {
        synchronized( rules ) {
            IRule result = rules.get(clazz);
            if(null == result) {
                result = clazz.newInstance();
                rules.put(clazz, result);
            }
            @SuppressWarnings("unchecked")
            T tmp = (T) result;
            return tmp;
        }
    } catch (Exception e) {
        log( "Unable to create IRule for {}", clazz );
    }
}