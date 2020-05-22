public static <T> T retry5Times(ThrowingSupplier<T, IOException> supplier) {
    for(int i = 0; i < 5; i++) {
        try {
            return supplier.get();
        } catch (IOException e) {
            LOGGER.logWarn("Problem Occured While Downloading The File= " + e.getMessage());
        }
    }
    return null;
}