<T> T getValue(Map<String, Object> dataMap, String value, Class<T> type) 
        { 
            Object value = dataMap.get(value);
            if(value!=null && !type.isInstance(value))  // check!
                throw new ClassCastException();

            @SuppressWarning("unchecked")
            T t = (T)value;  // this is safe, because we've just checked
            return t;
        }