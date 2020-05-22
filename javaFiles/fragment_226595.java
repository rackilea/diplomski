public final <S, T> List<S> getKeysForValue(final HashMap<S, T> hashMap, final T value) {
    return hashMap.entrySet()
                  .stream()
                  .filter(entry -> entry.getValue().equals(value))
                  .map(Map.Entry::getKey)
                  .collect(Collectors.toList());
}