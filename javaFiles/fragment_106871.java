@Singleton
public class OnStartup {

    private final Cancellable cancellableSchedule;

    @Inject
    public OnStartup(final ActorSystem system, final ApplicationLifecycle l) {
        cancellableSchedule = startScheduler(system);
        initStopHook(l);
    }

    private Cancellable startScheduler(final ActorSystem system) {
        return startImagesCleanupScheduler(system);
        Logger.info("Schedulers started");
    }

    private Cancellable startImagesCleanupScheduler(ActorSystem system) {
        return system.scheduler().schedule(
            Duration.create(0, TimeUnit.MILLISECONDS), //Initial delay
            Duration.create(1, TimeUnit.DAYS),     //Frequency 1 days
            () -> {
                //int rows = imageService.cleanupInactiveImages();
                rows = 1;
                Logger.info(String.format("%d inactive unused images cleaned from db", rows ));
                },
            system.dispatcher()
        );
    }

    private void initStopHook(ApplicationLifecycle lifecycle) {
       lifecycle.addStopHook(() -> {
            cancellableSchedule.cancel();
        return CompletableFuture.completedFuture(null);
        });
     }

}