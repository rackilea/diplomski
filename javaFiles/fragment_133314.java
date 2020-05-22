@IntDef({Status.IDLE, Status.PROCESSING, Status.DONE, Status.CANCELLED})
@Retention(RetentionPolicy.SOURCE)
@interface Status {
    int IDLE = 0;
    int PROCESSING = 1;
    int DONE = 2;
    int CANCELLED = 3;
}