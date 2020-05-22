ArrayList<UserModel> userModelArrayList = new ArrayList<>();
    UserModel user;
    for (int i = 0; i < 20; i++) {
        if (i % 2 == 0)
            user = new UserModel(25, "user" + i);
        else
            user = new UserModel(15, "user" + i);

        userModelArrayList.add(user);
    }

    io.reactivex.Observable
            .fromIterable(userModelArrayList)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .filter(userModel -> userModel.getAge() > 18)
            .toList()
            .subscribe(new SingleObserver<List<UserModel>>() {
                @Override
                public void onSubscribe(Disposable d) {
                    /* to do */
                }

                @Override
                public void onSuccess(List<UserModel> userModels) {
                    Log.d("userModels", " after filtering: " + userModels.size());

                }

                @Override
                public void onError(Throwable e) {
                    /* to do */
                }
            });