public class Cleaner {
    public interface Cleanable {
        void clean();
    }
    public static Cleanable register(Object o, Runnable r) {
        CleanerReference c = new CleanerReference(
                Objects.requireNonNull(o), Objects.requireNonNull(r));
        phantomReferences.add(c);
        return c;
    }
    private static final Set<CleanerReference> phantomReferences
                                             = ConcurrentHashMap.newKeySet();
    private static final ReferenceQueue<Object> garbageCollectedObjectsQueue
                                              = new ReferenceQueue<>();

    static final class CleanerReference extends PhantomReference<Object>
                                        implements Cleanable {
        private final Runnable cleaningAction;

        CleanerReference(Object referent, Runnable action) {
            super(referent, garbageCollectedObjectsQueue);
            cleaningAction = action;
        }
        public void clean() {
            if(phantomReferences.remove(this)) {
                super.clear();
                cleaningAction.run();
            }
        }
    }
    public static void deleteOrphanedNativePeerObjects() {
        CleanerReference reference;
        while((reference=(CleanerReference)garbageCollectedObjectsQueue.poll()) != null) {
            reference.clean();
        }
    }
}