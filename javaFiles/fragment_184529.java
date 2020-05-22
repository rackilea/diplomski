public Flowable<List<MovieEntity>> getMovies() {
        return mLocal.allMovies().take(1)
                .filter(list -> !list.isEmpty())
                .switchIfEmpty(mRemote.allMovies()
                                .doOnNext(data -> mLocal.saveAll(data))
                        );
    }