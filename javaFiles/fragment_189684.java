IntConsumer callback = (param) -> {
    for (int i = 0; i < param; i++) {
        System.out.println(i);
    }
};

callback.accept(10);