HashSet<ValueObject> valueObjects = new HashSet<>();
valueObjects.add(ValueObject.of(1));
valueObjects.add(ValueObject.of(2));
valueObjects.add(ValueObject.of(3));

HashSet<DTO> dtos = new HashSet<>();
dtos.add(DTO.of(1));
dtos.add(DTO.of(2));
dtos.add(DTO.of(34));

boolean areIdentical = Arrays.equals(
    valueObjects.stream()
        .mapToInt((v) -> v.id)
        .sorted()
        .toArray(),
    dtos.stream()
        .mapToInt((d) -> d.id)
        .sorted()
        .toArray()
);