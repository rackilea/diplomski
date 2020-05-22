private static final ExecutorService DELETE_SERVICE = Executors.newSingleThreadExecutor();

public static void deleteFile(final File file) {
    if (file != null) {
        DELETE_SERVICE.submit(new Runnable() {
            @Override
            public void run() {
                file.delete();
            }
        });
    }
}