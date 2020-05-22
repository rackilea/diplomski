public static <E, D extends Comparable<? super D>> Specification<E> andRangeIfSet(Specification<E> spec, final List<Range<E, D>> ranges) {
    for (Range<E, D> range : ranges) {
        if (range.isSet()) {
            spec = spec.and(toSpecification(range));
        }
    }
    return spec;
}