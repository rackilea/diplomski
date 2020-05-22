// Test first without locking to reduce the concurrency bottleneck
if (!dir.exists()) {
    synchronize (globalDirLock) {
        // Repeat the test while holding the lock
        if (!dir.exists()) { 
            if (!dir.mkdir()) {
                System.out.println("OOOPS!");
            }
        }
    }
}