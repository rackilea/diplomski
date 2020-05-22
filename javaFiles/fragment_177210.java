private static Set<Manufacture> manufacturers = Collections.unmodifiableSet(
        Stream.of(values()).map(MyEnum::getManufacture).collect(Collectors.toSet())
);

public static Set<String> getManufacturers() {
    return manufacturers;
}