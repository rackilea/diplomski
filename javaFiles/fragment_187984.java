try {
        while (true) {
            Integer thing = queue.take();
        }
    } catch (InterruptedException ex) {
        // something want's us to stop.
    }