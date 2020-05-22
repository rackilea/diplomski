public SomeObject add(String string, PARAMETERS_TO_CONSTRUCT_SomeObject) {
        SomeObject result = concurrentHashMap.get(string);        
        if (result == null) {
            result = new SomeObject(PARAMETERS_TO_CONSTRUCT_SomeObject);
            SomeObject old = map.putIfAbsent(string, result);
            if (old != null) {
                result = old;
            }
        }
        return result;
    }