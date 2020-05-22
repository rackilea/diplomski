String filename = "yourFileName";
    String url = "http://your.url.here";
    File saveLocation = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile(), filename);
    downloadFile(url, saveLocation)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext(fileDownloadProgress -> {
                float progress = fileDownloadProgress.getProgress();
                // TODO update UI
            })
            .filter(DownloadProgress::isDone)
            .map(DownloadProgress::getData)
            .subscribe(file -> {
                // file downloaded
            }, throwable -> {
                // error
            });