public static <T> void validateInput(List<T> assets, String requestId, Function<T, String> mapper) {
    if(CollectionUtils.isEmpty(assets)) {
        throw some error;
    }

    Set<String> uniqueIds = assets.stream().map(mapper).collect(Collectors.toSet());
    if(uniqueIds.size() != assets().size()) {
        throw some Error;
    }
}