Collector.of(
    // Supplier of accumulators
    ArrayList::new,
    // Accumulation operation
    List::add,
    // Combine accumulators
    (left, right) -> {
        left.addAll(right);
        return left;
    }
)