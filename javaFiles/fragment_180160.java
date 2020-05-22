final Map<CarBrand, CarsSellers> ret = input.values()
        .stream()
        .filter(brand -> brand != CarBrand.BMW)
        .collect(toMap(
                identity(),
                brand -> new CarsSellers(immutableCars, this.carsDb.export(brand)),
                (l, r) -> {
                    throw new IllegalArgumentException("Duplicate keys " + l + "and " + r + ".");
                },
                () -> new EnumMap<>(CarBrand.class)));