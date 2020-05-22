Observable<File> task = scanner.getProcessDirectoryTask(mountPoint);
Subscription _subscription = task
        .onBackpressureBuffer(10000)
        .filter(new Func1<File, Boolean>() {
            @Override
            public Boolean call(File file) {
                return file.getAbsolutePath().endsWith("xyz");
            }
        })
        .buffer(100)
       .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<List<File>>() { /*whatever you want to do*/ }