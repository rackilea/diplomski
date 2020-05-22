public class IntRange extends Range<Integer> {

    public IntRange(Integer from, Integer to) {
        super(from, to);
    }

    public Integer getDistance() {
        return getTo() - getFrom();
    }
}

public class IntAnimationProperties extends AbstractAnimationProperties<Integer> {

    public IntAnimationProperties(IntRange animationRange, IntRange maxRange, Duration duration, AnimationPropertiesListener<Integer> listener) {
        super(animationRange, listener);

        int maxDistance = maxRange.getDistance();
        int aniDistance = animationRange.getDistance();

        double progress = Math.min(100, Math.max(0, Math.abs(aniDistance/ (double)maxDistance)));
        Duration remainingDuration = Duration.ofMillis((long)(duration.toMillis() * progress));
        setDuration(remainingDuration);
    }

    @Override
    public Integer calculateValue(double progress) {
        IntRange range = (IntRange)getRange();
        int distance = range.getDistance();
        int value = (int) Math.round((double) distance * progress);
        value += range.getFrom();
        return value;
    }

}