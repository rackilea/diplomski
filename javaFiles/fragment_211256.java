public void getArticles(String get, final boolean needRefresh) throws IOException {

             Observable.create(new Observable.OnSubscribe<List< ArticleModel >>() {
                @Override
                public void call(Subscriber<? super List< ArticleModel >> subscriber) {

                        subscriber.onNext(parseArticles(get));
                        subscriber.onCompleted();

                }
            }).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<List<ArticleModel>>() {

                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable e) {
                    Log.i("SIZE", "onNext: "+ e.toString());
                }

                @Override
                public void onNext(List<ArticleModel> articleModels) {

                }
            });
        }
}