Flux<SearchResultType> flux = Flux.generate(
            () -> new SearchSupplier(this, queryBody),
            (supplier, sink) -> {
                SearchResultType current = supplier.next();
                if (isNotLast(current)) {
                    sink.next(current);
                } else {
                    sink.complete();
                }
                return supplier;
            },
            supplier -> anyCleanupOperations(supplier)
        );