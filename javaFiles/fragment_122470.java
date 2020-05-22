public interface Api {

    @Streaming
    @GET("path to file")
    Observable<ResponseBody> getFile();
}

api.getFile()
            .flatMap(responseBody -> {
                try {
                    return Observable.just(responseBody.string());
                } catch (IOException e) {
                    return Observable.error(e);
                }
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(System.out::println);