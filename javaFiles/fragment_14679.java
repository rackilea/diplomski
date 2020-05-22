interface FileRepository {
        String getFile();

        Boolean isMainFileExists();
}

private static Scheduler executorService = Schedulers.from(Executors.newFixedThreadPool(1));

@org.junit.Test
public void schedulerTest123() throws Exception {
        FileRepository fRepo = mock(FileRepository.class);

        when(fRepo.getFile()).thenReturn("");
        when(fRepo.isMainFileExists()).thenReturn(false);

        Thread t1 = new Thread(() -> {
            getFile(fRepo, executorService).subscribe();
        });

        Thread t2 = new Thread(() -> {
            getFile(fRepo, executorService).subscribe();
        });

        t1.start();
        t2.start();

        Thread.sleep(3_000);

        when(fRepo.getFile()).thenReturn("DasFile");
        when(fRepo.isMainFileExists()).thenReturn(true);

        Thread t3 = new Thread(() -> {
            getFile(fRepo, executorService).subscribe();
        });

        t3.start();

        Thread.sleep(5_000);
}

private Observable<String> getFile(FileRepository fileRepo, Scheduler scheduler) {
        return Observable.defer(() -> {
            try {
                if (fileRepo.isMainFileExists()) {
                    return Observable.fromCallable(fileRepo::getFile)
                            .subscribeOn(Schedulers.io())
                            .doOnNext(s -> printCurrentThread("Get File from Repo"));
                } else {
                    return startLongProcess().doOnNext(s -> printCurrentThread("Push long processValue"));
                }

            } catch (Exception ex) {
                return Observable.error(ex);
            }
        }).subscribeOn(scheduler).doOnSubscribe(disposable -> printCurrentThread("SUB"));
    }

private Observable<String> startLongProcess() {
        return Observable.fromCallable(() -> {
            printCurrentThread("Doing LongProcess");

            Thread.sleep(5_000);

            return "leFile";
        });
}

private void printCurrentThread(String additional) {
        System.out.println(additional + "_" + Thread.currentThread());
}