public ImageInputStream createInputStreamInstance(Object input,
                                                  boolean useCache,
                                                  File cacheDir) {
    if (input instanceof File) {
        try {
            return new FileImageInputStream((File)input);
        } catch (Exception e) {
            return null;
        }
    } else {
        throw new IllegalArgumentException();
    }
}