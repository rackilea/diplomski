try {
        while (true) {
            queue.put(1);
        }
    } catch (InterruptedException ex) {
        // something want's us to stop.
    }