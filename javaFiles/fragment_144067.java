while (true) {
    // only one call to the concurrent queue
    Message message = messageHolder.poll();
    if (message == null) {
        break;
    }
    ...
}