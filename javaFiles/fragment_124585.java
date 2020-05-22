<T extends Record> Result<T> fetchUnion(Select ... selects) {
   return Stream.of(selects)
                .reduce(Select::union)
                .map(Select::fetch)
                .orElse ... ;
}