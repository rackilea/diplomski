public static class ListenerHandler implements IgniteBiPredicate<UUID, Object> {
    @IgniteInstanceResource
    private Ignite ignite;

    private transient IgniteSemaphore sem;

    private IgniteSemaphore semaphore() {
        if (sem != null)
            return sem;

        sem = ignite.semaphore("sem", 1, true, true);
        return sem;
    }

    @Override public boolean apply(UUID uuid, Object o) {
        // ...
    }
}