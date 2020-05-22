try {
    setAlwaysOnTop(true);
} catch (Exception e) {
    log.warn("Could not update always on top", e);
    // do some stuff
}