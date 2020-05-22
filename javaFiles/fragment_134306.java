while (true) {
    try {
        synchronized (LogService.this) {
            if (isShutdown && reservations == 0)
                break;
        }
        String msg = queue.take();
        synchronized (LogService.this) {
            --reservations;
        }
        writer.println(msg);
    } catch (InterruptedException e) { /* retry */ } // interruption policy
}