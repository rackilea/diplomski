Observable.zip(baseDataObservable, usersObservable, new BiFunction<Users, Users, ArrayList<Items>>() {
        @Override
        public ArrayList<Items> apply(Users usersFromApi, Users usersUserDefined) throws Exception {
            ArrayList<Items> itemsArrayList = new ArrayList<>();
            itemsArrayList.addAll(usersFromApi.getItems());
            itemsArrayList.addAll(usersUserDefined.getItems());
            return itemsArrayList;
        }
    }).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new DisposableObserver<ArrayList<Items>>() {
                @Override
                public void onNext(ArrayList<Items> items) {
                    // here is the combined Arraylist
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });