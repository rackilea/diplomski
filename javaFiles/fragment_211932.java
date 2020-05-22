class ObjectMatcher {

    // NPE on null items
    // assumes public default constructor for T is available
    public <T> T match(Collection<T> items, T defaults) {
        if (items.isEmpty()) {
            return defaults;
        }
        try {
            @SuppressWarnings("unchecked")
            Class<T> clazz = (Class<T>) items.iterator().next().getClass();
            Field[] fields = clazz.getDeclaredFields();

            T res = clazz.newInstance();

            for (Field field : fields) {
                boolean firstItem = true;
                Object match = null;
                for (T item : items) {
                    Object value = field.get(item);
                    if (firstItem) {
                        match = value;
                    }
                    else if (!Objects.equals(value, match)) {
                        match = field.get(defaults);
                        break;
                    } // otherwise keep the match as is
                    firstItem = false;
                }
                field.set(res, match);
            }
            return res;
        }
        catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}