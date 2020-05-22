Flowable<Item> loadRange(int start, int number) {
        return Flowable.create(emitter -> {
            try {
                while (...){
                    emitter.onNext(new Item());
                }
                emitter.onComplete();
            } catch (IOException e) {
                emitter.onError(e);
            }
        }, BackpressureStrategy.BUFFER);
    }