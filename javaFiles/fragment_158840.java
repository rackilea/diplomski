flux
    .handle((foo, sink) -> {
        try {
            // propagate Baz down the stream
            sink.next(getBaz(foo));
        } catch (IOException e) {
            // Since sink.next is not called here,
            // the problematic element will be dropped from the stream
            log.error(e);
        }
    })