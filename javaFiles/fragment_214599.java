public static Singleton getInstance() {

    // Fast-path when singleton already constructed
    if(instance != null)
        return instance;

    // Spinlock lets the first thread through, others will spin
    while(instance == null && !isInitialized.compareAndSet(false, true))
        ;

    // First thread creates the singleton, spun threads will ignore
    if(instance == null)
        instance = new Singleton();

    return instance;
}