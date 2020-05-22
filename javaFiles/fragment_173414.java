private static final Predicate IS_ENOUGH_SPACE = exchange -> {
    return new File(Paths.get("").toUri()).getUsableSpace() > 100*1024*1024; // 100MB
};

public void configure() {
    from("timer:simple?period=1000")
        .choice().when(IS_ENOUGH_SPACE)
                .to("file://myStuff")
                .to("log:done")
            .otherwise()
                .to("log:supressed") // do some handling here, maybe pause route for while
            .end();
}