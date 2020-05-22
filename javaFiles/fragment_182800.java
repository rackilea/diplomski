private Disposable disposable;

private void myMethod(){
    Flowable<Progress<FileLink>> upload = new Client(myConfigOptionsHere)
      .uploadAsync(filePath, false, storageOptions);

        this.disposable = upload.doOnNext(progress -> {
                    double progressPercent = progress.getPercent();
                    if(progressPercent > 0){
                        //Updating progress here
                    }
                    if (progress.getData() != null) {
                        //Sending successful upload callback here
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        //Logging he complete action here
                    }
                })
                .doOnCancel(new Action() {
                    @Override
                    public void run() throws Exception {
                        //Logging the cancel here
                    }
                })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable t) throws Exception {
                        //Logging the error here
                    }
                })
                .subscribe();

}

public void cancelUpload(){
    if(this.disposable != null){
        this.disposable.dispose();
        this.disposable = null;
    }
}