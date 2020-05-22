Stream<Pair<Application, ApplicationQuote>> pairStream = application
           .map(app -> Pair.of(app, Optional.ofNullable(app.getQuotes())))
           .filter(quote -> quote.getValue().isPresent())
           .stream() // new API
           .flatMap(quote -> quote.getValue().orElse(Collections.emptyList())
                   .stream().map(q -> Pair.of(quote.getKey(), q)));