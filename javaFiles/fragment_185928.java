SimpleTestService testService = TestAdapter.createService();
testService .getPosts().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap(new Func1<List<Post>, Observable<Post>>() {
            @Override
            public Observable<Post> call(List<Post> posts) {
                return Observable.from(posts);
            }
        })
        .subscribe(new Observer<Post>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Post post) {
                String text = testText.getText().toString();
                text += post.getBody();
                testText.setText(text);
            }
        });