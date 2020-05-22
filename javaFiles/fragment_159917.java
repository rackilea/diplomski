Observable<Bitmap> getImage(final Activity activity) {
    return Observable.create(new Observable.OnSubscribe<Bitmap>() {
        @Override
        public void call(Subscriber<? super Bitmap> subscriber) {
            try {
                subscriber.onNext(downloadImage(activity.getImage()));
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        }
    });
}

Observable<HashMap<Integer, Bitmap>> getImages(final List<Activity> activities) {
    return Observable
        .from(activities)
        .reduce(new HashMap<Integer, Bitmap>(), new Func2<HashMap<Integer, Bitmap>, Activity, HashMap<Integer, Bitmap>>() {
            @Override
            public HashMap<Integer, Bitmap> call(final HashMap<Integer, Bitmap> bitmaps, final Activity activity) {
                getImage(activity)
                    .observeOn(Schedulers.io())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Action1<Bitmap>() {
                        @Override
                        public void call(Bitmap bitmap) {
                            bitmaps.put(activity.getId(), bitmap);
                        }
                    });
                return bitmaps;
            }
        });
}