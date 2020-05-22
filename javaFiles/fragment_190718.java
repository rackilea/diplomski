Optional<RandomObject> randomObj = mappy.entrySet().stream()
    .filter(map -> map.getKey() == 2)
    .mapToObj(entry -> new RandomObject(entry.getKey(), entry.getValue()))
    .findFirst();

if (!randomObj.isPresent()) {
    throw new IllegalStateException("No value with key = 2 were present");
}