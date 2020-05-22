public static Type concretify(Type from, Map<TypeVariable<?>, Type> mappings) {
    if(from instanceof ParameterizedType) {
        ParameterizedType pt = (ParameterizedType) from;

        Type[] ts = pt.getActualTypeArguments();
        Type[] result = new Type[ts.length];
        for (int i = 0; i < ts.length; i++) {
            result[i] = mappings.getOrDefault(ts[i], ts[i]);
        }

        return new ParameterizedType() { // some ParameterizedType implementation

            @Override
            public Type getRawType() {
                return pt.getRawType();
            }

            @Override
            public Type getOwnerType() {
                return pt.getOwnerType();
            }

            @Override
            public Type[] getActualTypeArguments() {
                return result;
            }

            @Override
            public String toString() {
                return String.format("%s<%s>", getRawType().getTypeName(),
                    Arrays.stream(getActualTypeArguments())
                        .map(Type::getTypeName)
                        .collect(Collectors.joining(",")));
            }
        };
    }
    return from;
}