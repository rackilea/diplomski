class Test {

    void useMonoVal(Mono<String> mono) {
        mono.subscribe(s -> System.out.println("I need to see " + s));
    }

    void anotherMethod(Mono<String> mono) {
        mono.subscribe(s -> System.out.println("I need to talk to " + s));
    }

    public static void main(String[] args) {
        Mono myMono = Mono.just("Bob").cache();
        Test t = new Test();
        t.useMonoVal(myMono);
        t.anotherMethod(myMono);
    }

}