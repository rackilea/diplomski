private static class CustomParameterizedType implements ParameterizedType {

    private Type rawType;
    private Type ownerType;
    private Type[] typeArguments;

    private CustomParameterizedType(Type rawType, Type ownerType, Type... typeArguments) {
        this.rawType = rawType;
        this.ownerType = ownerType;
        this.typeArguments = typeArguments;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return typeArguments;
    }

    @Override
    public Type getRawType() {
        return rawType;
    }

    @Override
    public Type getOwnerType() {
        return ownerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomParameterizedType that = (CustomParameterizedType) o;
        return Objects.equals(rawType, that.rawType) &&
                Objects.equals(ownerType, that.ownerType) &&
                Arrays.equals(typeArguments, that.typeArguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawType, ownerType, typeArguments);
    }
}