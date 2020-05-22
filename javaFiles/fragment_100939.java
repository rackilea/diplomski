public static Flowable<Path> listFolder(Path dir, String glob) {
    return Flowable.using(
        () -> Files.newDirectoryStream(dir, glob),
        stream -> Flowable.fromIterable(stream),
        stream -> stream.close());
}