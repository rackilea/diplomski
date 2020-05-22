for (int i = 0; i < processors; ++i) {
    theCores[i] = new detectors();
    theCores[i].start();
}

for (int i = 0; i < processors; ++i) {
    try {
        theCores[i].join();
    } catch (InterruptedException ie) {
        RuntimeException re = new RuntimeException("unsupported interruption", ie);
        for (++i; i < processors; ++i) {
            try {
                theCores[i].join();
            } catch (InterruptedException e) {
                re.addSuppressed(e);
            }
        }
        throw re;
    }
}