public interface AnimationPropertiesListener<T> {
    public void stateChanged(AnimationProperties<T> animator);
}

public interface AnimationProperties<T> {
    public Range<T> getRange();
    public T getValue();
    public boolean tick();

    public void setDuration(Duration duration);
    public Duration getDuration();
}

public abstract class AbstractAnimationProperties<T> implements AnimationProperties<T> {

    private Range<T> range;     
    private LocalDateTime startTime;
    private Duration duration = Duration.ofSeconds(5);
    private T value;
    private AnimationPropertiesListener<T> listener;

    public AbstractAnimationProperties(Range<T> range, AnimationPropertiesListener<T> listener) {
        this.range = range;
        this.value = range.getFrom();

        this.listener = listener;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

    public Range<T> getRange() {
        return range;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public boolean tick() {
        if (startTime == null) {
            startTime = LocalDateTime.now();
        }
        Duration duration = getDuration();
        Duration runningTime = Duration.between(startTime, LocalDateTime.now());
        Duration timeRemaining = duration.minus(runningTime);
        if (timeRemaining.isNegative()) {
            runningTime = duration;
        }
        double progress = (runningTime.toMillis() / (double) duration.toMillis());
        value = calculateValue(progress);

        listener.stateChanged(this);

        return progress >= 1.0;
    }

    public abstract T calculateValue(double progress);

}