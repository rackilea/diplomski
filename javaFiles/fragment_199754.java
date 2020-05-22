RestWebClient.get().getFirstImage()
        .flatMap(firstImage -> /* first image success */ ? RestWebClient.get().getSecondImage() : Observable.just(null),
                (firstImage, secondImage) -> Pair.create(firstImage, secondImage))
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(imagePair -> mainFragmentPresenterInterface.showImages(imagePair));