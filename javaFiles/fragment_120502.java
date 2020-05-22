public class TimeLine {

    private Map<Float, KeyFrame> mapEvents;

    private Duration duration;
    private LocalDateTime startedAt;

    public TimeLine(Duration duration) {
        mapEvents = new TreeMap<>();
        this.duration = duration;
    }

    public void start() {
        startedAt = LocalDateTime.now();
    }

    public boolean isRunning() {
        return startedAt != null;
    }

    public float getValue() {
        if (startedAt == null) {
            return getValueAt(0.0f);
        }
        Duration runningTime = Duration.between(startedAt, LocalDateTime.now());
        if (runningTime.compareTo(duration) > 0) {
            runningTime = runningTime.minus(duration);
            startedAt = LocalDateTime.now().minus(runningTime);
        }
        long total = duration.toMillis();
        long remaining = duration.minus(runningTime).toMillis();
        float progress = remaining / (float) total;
        return getValueAt(progress);
    }

    public void add(float progress, float value) {
        mapEvents.put(progress, new KeyFrame(progress, value));
    }

    public float getValueAt(float progress) {

        if (progress < 0) {
            progress = 0;
        } else if (progress > 1) {
            progress = 1;
        }

        KeyFrame[] keyFrames = getKeyFramesBetween(progress);

        float max = keyFrames[1].progress - keyFrames[0].progress;
        float value = progress - keyFrames[0].progress;
        float weight = value / max;

        float blend = blend(keyFrames[0].getValue(), keyFrames[1].getValue(), 1f - weight);
        return blend;
    }

    public KeyFrame[] getKeyFramesBetween(float progress) {

        KeyFrame[] frames = new KeyFrame[2];
        int startAt = 0;
        Float[] keyFrames = mapEvents.keySet().toArray(new Float[mapEvents.size()]);
        while (startAt < keyFrames.length && keyFrames[startAt] <= progress) {
            startAt++;
        }

        if (startAt >= keyFrames.length) {
            startAt = keyFrames.length - 1;
        }

        frames[0] = mapEvents.get(keyFrames[startAt - 1]);
        frames[1] = mapEvents.get(keyFrames[startAt]);

        return frames;

    }

    protected float blend(float start, float end, float ratio) {
        float ir = (float) 1.0 - ratio;
        return (float) (start * ratio + end * ir);
    }

    public class KeyFrame {

        private float progress;
        private float value;

        public KeyFrame(float progress, float value) {
            this.progress = progress;
            this.value = value;
        }

        public float getProgress() {
            return progress;
        }

        public float getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "KeyFrame progress = " + getProgress() + "; value = " + getValue();
        }

    }

}