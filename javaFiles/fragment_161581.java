PathwayImpl p = null;
synchronized (bq) {
    try {
        while (bq.isEmpty() && !stopSignal) {
            bq.wait(3000); // Wait up to 3 seconds and check again
        }

        if (!stopSignal) {
            p = bq.poll();
        }
    }
    catch (InterruptedException ie) {
        // Broke us out of waiting, loop around to test the stopSignal again
    }
}