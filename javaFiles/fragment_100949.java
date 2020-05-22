public interface TypedTemporalAdjuster<T extends Temporal & Comparable<? super T>>
extends TemporalAdjuster {

    static <T extends Temporal & Comparable<? super T>> TypedTemporalAdjuster<T> of(
            final Class<T> temporalClass, final TemporalAdjuster temporalAdjuster) {
        return temporal -> temporalClass.cast(temporalAdjuster.adjustInto(temporal));
    }

    @Override T adjustInto(Temporal temporal);
}