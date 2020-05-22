Type typeOfSrc = type(JsonConverter.class, clazz);

// type(C, A1,...,An) => C<A1,...,An>
static ParameterizedType type(final Class raw, final Type... args)
{
    return new ParameterizedType()
    {
        public Type getRawType(){ return raw; }

        public Type[] getActualTypeArguments(){ return args; }

        public Type getOwnerType(){ return null; }
    };
}