// There is a thread array field in the ThreadGroup class.
Field f = ThreadGroup.class.getDeclaredField("threads");
// The 'threads' field has no access modifiers.
f.setAccessible(true);

Thread[] threads = (Thread[]) f.get(Thread.currentThread().getThreadGroup());
/*
 * Search 'threads' accordingly...
 */