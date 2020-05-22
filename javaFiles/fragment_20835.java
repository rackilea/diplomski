public static void deleteFile(final File file) {
    if (file != null) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                file.delete();
            }
        }).start();
    }
}