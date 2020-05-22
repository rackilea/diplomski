while(true) {
        // Let queue be a synchronized, global queue
        if (queue has an element) {
            // Pop from queue and do a very minimal amount of work on it
            // Involves a small amount of network IO (maybe 10-100 ms)
        } else {
            sleep(2000);
        }
    }