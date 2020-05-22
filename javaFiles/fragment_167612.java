Observable.create((ObservableEmitter<byte[]> e) -> {
    FileInputStream fin = new FileInputStream("raw.dat");
    e.setCancellable(fin::close);

    byte[] buffer = new byte[4096];

    for (;;) {
        int r = fin.read(buffer);
        if (r < 0) {
            break;
        }
        e.onNext(buffer);
    }
    e.onComplete();
});