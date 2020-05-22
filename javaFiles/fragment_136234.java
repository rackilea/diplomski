public void execute(Runnable command) {
    if (command == null)
        throw new NullPointerException();
    if (poolSize >= corePoolSize) {
        // there are enough core threads
        // let's try to put task on the queue
        if (runState == RUNNING && workQueue.offer(command)) {
            if (runState != RUNNING || poolSize == 0)
                ensureQueuedTaskHandled(command);
        } else if (!addIfUnderMaximumPoolSize(command))
            reject(command); // is shutdown or saturated
    } else if (addIfUnderCorePoolSize(command)) {
        // there was not enough core threads, so we started one
        // the task is being executed on a new thread, so there's nothing else to be done here
        return;
    } else {
        // there are enough core threads
        // but we could not start a new thread
        // so let's try to add it to the queue
        if (runState == RUNNING && workQueue.offer(command)) {
            if (runState != RUNNING || poolSize == 0)
                ensureQueuedTaskHandled(command);
        } else if (!addIfUnderMaximumPoolSize(command))
            reject(command); // is shutdown or saturated
    }
}