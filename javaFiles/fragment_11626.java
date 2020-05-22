@Autowired Tracer tracer;

private void someMethod(long traceId) {
    Span span = Span.builder()
        .traceId(traceId)
        .spanId(new Random().nextLong())
        .build();
    tracer.continueSpan(span);
    // do work
    tracer.closeSpan(span);
}