ArrayList<Float> listValues = new ArrayList<>(
    Arrays.stream(
        checkvalue.split("[\\r\\n]+"))
            .map(Float::parseFloat).collect(Collectors.toList()
    )
);