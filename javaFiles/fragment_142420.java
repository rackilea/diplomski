public Single<List<Modifications>> loadModificationsImages() {
    return Observable.fromCallable(DataStoreRepository::loadModifications)
            .subscribeOn(Schedulers.io())
            .flatMapIterable(list -> list)
            .flatMapSingle(item -> 
                Observable.fromIterable(item.images)
                .flatMap(image ->
                    ApiRepository.getModificationsImages(item.id, image.id)
                    .subscribeOn(Schedulers.io())
                    .retry(3)
                    .map(response -> {
                        InputStream is = response.byteStream();

                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = Bitmap.Config.RGB_565;

                        Bitmap bitmap = BitmapFactory.decodeStream(is, null, options);

                        String contentSubType = response.contentType().subtype();
                        String fileName = "modifications_id_" + item.id + "_image_id_"
                            + image.id + "." + contentSubType;
                        FileUtil.saveBitmap(bitmap, fileName);

                        Modifications.Images img = new Modifications.Images(
                            image.id, fileName, image.type);
                        return img;
                    })
                )
                .toList()
                .doOnSuccess(images -> 
                    DataStoreRepository.updateListOfModificationsImage(images, image.id)
                )
            );
}