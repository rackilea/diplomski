// communicating with FB
try {
    Thread.sleep(1000); sleep one second to give other threads a chance
} catch (InterruptedException e) {
    // We've been interrupted: stop talking to FB and return
    return;
}