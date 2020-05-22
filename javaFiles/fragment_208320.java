AppObservable.bindFragment(this, Observable.just(0))
   .observeOn(Schedulers.io())
   .doOnNext(v -> WallpaperHelper.setBitmapAsWallpaper(photoViewAttacher.getVisibleRectangleBitmap(), getBaseActivity()))
   .delay(500, TimeUnit.MILLISECONDS)
   .observeOn(AndroidSchedulers.mainThread())
   .subscribe(v -> loadFinishAnimationAfterSetWallpaper());