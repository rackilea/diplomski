Observable<File> task = scanner.getProcessDirectoryTask(mountPoint);
Subscription _subscription = task
       .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .onBackpressureBuffer(10000)
        .filter(new Func1<File, Boolean>() {
            @Override
            public Boolean call(File file) {
                return file.getAbsolutePath().endsWith("xyz");
            }
        })
        .buffer(100)
        .subscribe(new Observer<List<File>>() { /*whatever you want to do*/ }