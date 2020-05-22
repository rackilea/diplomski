public class HourException extends Exception {
    private boolean normalViolated_;
    private boolean coreViolated_;

    public HourException(String message, boolean normalViolated, boolean coreViolated) {
         super(message);
         normalViolated_ = normalViolated;
         coreViolated_ = coreViolated;
    }

    public boolean isCoreViolated() {
         return coreViolated_;
    }

    public boolean isNormalViolated() {
         return normalViolated_;
    }
}