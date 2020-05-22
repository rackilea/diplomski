class Position {
    Optional<PositionValue> value = Optional.empty();
    public Position mapOrSelf(Function<? super PositionValue, ? extends Position> f) {
        return value.map(f).orElse(this);
    }
}