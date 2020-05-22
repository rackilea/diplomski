while (selector.isOpen() && !Thread.interrupted()) {
    for (;;) {
        Request r=queue.poll(); // requests can be both to read and write
        if (r==null) {
            break;
        }
        processRequest(r);
    }

    selector.select(); // wait for next event

    // Iterate over the set of keys for which events are available
    Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
    while (selectedKeys.hasNext()) {
        SelectionKey key = selectedKeys.next();
        selectedKeys.remove();
        processKey(key);
    }
}