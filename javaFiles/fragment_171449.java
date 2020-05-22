@Bean
public Supplier<Flux<String>> sup() {
    return () -> Flux.fromStream(Stream.generate(new Supplier<String>() {

        @Override
        public String get() {
            try {
                Thread.sleep(1000);
                return "Hello from Supplier";
            } catch (Exception e) {
                // ignore
            }
        }

    })).subscribeOn(Schedulers.elastic()).share();
}