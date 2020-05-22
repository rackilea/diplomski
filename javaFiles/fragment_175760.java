class IllegalValue {
    @SuppressWarnings("ConstantConditions")
    static @Nonnull <T> T sneakyNullReference() {
        return null;
    }
}