@Override        
protected Object resolveContainerStore(String key) {
                Object value = getProperty(key);
                if (value != null) {
                    if (value instanceof Collection) {
                        Collection collection = (Collection) value;
                        Iterator iterator = collection.iterator();
                        value = null;
                        while (iterator.hasNext()) {
                            value = iterator.next();
                        }
                    } else if (value.getClass().isArray() && Array.getLength(value) > 0) {
                        value = Array.get(value, Array.getLength(value) - 1);
                    }
                }
                return value;
            }