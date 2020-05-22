String filename = "yourFileName";
    downloadFile(filename)
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