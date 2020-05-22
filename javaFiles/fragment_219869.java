public Thread[] getThreadsOf(ThreadGroup group) {
    int estimate = group.activeCount();
    Thread[] groupThreads = new Thread[estimate];
    while(group.enumerate( groupThreads, false ) == groupThreads.length) {
        groupThreads = new Thread[ groupThreads.length * 2 ];
    }
    return groupThreads;
}