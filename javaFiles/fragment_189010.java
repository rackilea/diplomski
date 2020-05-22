synchronized(monitor) {
    monitor.wait();   // wait for signal
}

// read from input stream

synchronized(monitor) {
    monitor.notify(); // release the next thread to start reading
}