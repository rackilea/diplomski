<T extends Record> Result<T> fetchUnion(List<Select<T>> selects) {
    return selects.stream()
                  .reduce(Select::union)
                  .map(Select::fetch)
                  .orElseThrow(() -> /* your exception? */);
}