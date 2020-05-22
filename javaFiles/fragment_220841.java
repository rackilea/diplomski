API.getUserByID("USER ID")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext(user_ -> {calls on observer thread})
        .flatMap(user-> {
            return API.getParentName(user.getId()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        })
        .subscribe(parent-> {
            // It's ok to update UI cause of on main thread.
            parentTextView.setText(parent.getName())
        });