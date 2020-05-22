Observable.<Event>create(emitter -> {
    Callback listener = new Callback() {
        @Override
        public void onEvent(Event e) {
            emitter.onNext(e);
            if (e.isLast()) {
                emitter.onCompleted();
            }
        }

        @Override
        public void onFailure(Exception e) {
            emitter.onError(e);
        }
    };

    AutoCloseable c = api.someMethod(listener);

    emitter.setCancellation(c::close);

}, BackpressureMode.BUFFER);