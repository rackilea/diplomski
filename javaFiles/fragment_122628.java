final PutObjectRequest putObjectRequest = new PutObjectRequest("a", "b", "c");
    Observable.create(new Observable.OnSubscribe<SomeAmazonModel>() {
        @Override
        public void call(final Subscriber<? super SomeAmazonModel> subscriber) {
            putObjectRequest.setGeneralProgressListener(new S3ProgressListener() {
                @Override
                public void onPersistableTransfer(PersistableTransfer persistableTransfer) {

                }

                @Override
                public void progressChanged(com.amazonaws.event.ProgressEvent progressEvent) {
                    if (progressEvent.getEventCode() == ProgressEvent.COMPLETED_EVENT_CODE) {
                        subscriber.onNext(new SomeAmazonModel(ProgressEvent.COMPLETED_EVENT_CODE));
                        subscriber.onCompleted();
                    } else if (progressEvent.getEventCode() == ProgressEvent.FAILED_EVENT_CODE) {
                        subscriber.onNext(new SomeAmazonModel(ProgressEvent.COMPLETED_EVENT_CODE));
                    }
                }
            });
        }
    }).subscribe(new Action1<SomeAmazonModel>() {
        @Override
        public void call(SomeAmazonModel someAmazonModel) {
            // Subscribe to above Observable and handle result
            someAmazonModel.getEventCode();
        }
    });