protected Object resolveContainerStore(String key)
    {
        Object value = getProperty(key);
        if (value != null)
        {
            if (value instanceof Collection)
            {
                Collection collection = (Collection) value;
                value = collection.isEmpty() ? null : collection.iterator().next();
            }
            else if (value.getClass().isArray() && Array.getLength(value) > 0)
            {
                value = Array.get(value, 0);
            }
        }

        return value;
    }