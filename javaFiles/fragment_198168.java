Observable.from(artistNames)
            .map(name -> name.replace(" ", "+"))
            .flatMap(name -> googleImageAPI.loadPhotos(name))
            .toList()
            .subscribe(new Subscriber<List<Github>>() {
                @Override
                public final void onCompleted() {
                    // do nothing
                }

                @Override
                public final void onError(Throwable e) {
                    Log.e("GithubDemo", e.getMessage());
                }

                @Override
                public final void onNext(List<Github> response) {
                    mCardAdapter.addAll(response);
                }
            })