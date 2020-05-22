private void setupLibVLC() throws LibraryNotFoundException {

    new NativeDiscovery().discover();

    // discovery()'s method return value is WRONG on Linux
    try {
        LibVlcVersion.getVersion();
    } catch (Exception e) {
        throw new LibraryNotFoundException();
    }
}