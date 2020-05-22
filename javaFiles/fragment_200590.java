Flowable<Item> loadRange(int start, int number) {
        return Flowable.create(new FlowableOnSubscribe<Item>() {
            @Override public void subscribe(FlowableEmitter<Item> emitter) {
                try {
                    while (...){
                        emitter.onNext(new Item());
                    }
                    emitter.onComplete();
                } catch (IOException e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }