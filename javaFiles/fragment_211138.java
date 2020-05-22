ReentrantLock selectorGuard;
Selector selector;

private void doSelect() {
    // Don't enter a select if another thread is in a critical block
    selectorGuard.lock();
    selectorGuard.unlock();

    selector.select();
    Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();

    while(keyIter.hasNext()) {

        SelectionKey key = keyIter.next();
        keyIter.remove();

        // Process key
    }
}

private void addToSelector() {

    // Lock the selector guard to prevent another select until complete
    selectorGuard.lock();

    try {
        selector.wakeup();

        // Do logic that registers channel with selector appropriately

    } finally {
        selectorGuard.unlock();
    }
}