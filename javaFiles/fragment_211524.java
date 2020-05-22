public static class Builder<T> {
        public final T instance;

        public Builder(Class<T> clazz) throws InstantiationException,
                IllegalAccessException {
            super();
            this.clazz = clazz;
            this.instance = clazz.newInstance();
        }

        private final Class<?> clazz;

        Builder<T> setProperty(String name, Object value)
                throws IllegalAccessException, IllegalArgumentException,
                InvocationTargetException, NoSuchMethodException,
                SecurityException {

            Method method = clazz.getMethod("set"
                    + name.substring(0, 1).toUpperCase() + name.substring(1),
                    value.getClass());
            method.invoke(instance, value);
            return this;
        }

        T create() {
            return instance;
        }
    }