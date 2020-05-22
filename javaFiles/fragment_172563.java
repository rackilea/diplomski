public abstract class BaseJob extends Job {
    // annotate fields that should be injected and made available to subclasses
    @Inject MyService service;

    protected BaseJob(Params params) {
        super(params);
    }
}