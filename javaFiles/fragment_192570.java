/**
     * Sort using natural order of {@literal <T>} which must be
     * {@code Comparable}.
     */
    OfRef(AbstractPipeline<?, T, ?> upstream) {
        super(upstream, StreamShape.REFERENCE,
              StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
        this.isNaturalSort = true;