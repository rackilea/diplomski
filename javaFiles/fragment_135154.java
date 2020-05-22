@Get(uri = "/xml", produces = MediaType.TEXT_XML)
Flowable<String> getXml() {
    return Flowable.create(emitter -> {
        emitter.onNext("<<xml header>>");
        //do some work
        emitter.onNext("more xml");
        emitter.onNext("<<xml footer>>");
    }, BackpressureStrategy.BUFFER);
}