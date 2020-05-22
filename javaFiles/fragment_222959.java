Handler handler = new Handler();

Runnable everyXMillis(Runnable inner, int ms) {
    return () -> {
        inner.run();
        handler.postDelayed(everyXMillis(inner, ms), ms);
    };
}

void testWithMethodReference() {
    handler.post(everyXMillis(() -> {
        // do something
    }, 200));
}