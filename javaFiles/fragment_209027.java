try {
    binder().bind(Integer.TYPE).toInstance(10);

    binder().bind(new TypeLiteral<BlockingQueue<String>>() {})
        .toConstructor(LinkedBlockingQueue.class.getConstructor(Integer.TYPE));
} catch (NoSuchMethodException e) {
    addError(e);
}