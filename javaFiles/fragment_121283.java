interface Option<T> {
    <U> Option<U> flatMap(Function<T, Iterable<U>> mapper) {
        if (isEmpty()) {
            return none();
        } else {
            Iterable<U> iterable = mapper.apply(get());
            if (isEmpty(iterable)) {
                return none();
            } else {
                U resultValue = whatToDoWith(iterable); // ???
                return some(resultValue);
            }
        }
    }
}