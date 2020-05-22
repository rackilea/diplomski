static <E> List<E> getListForOlderGson(final ... source, final Type type) {
    return gson.fromJson(source, new ParameterizedType() {
        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{ type };
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    });
}