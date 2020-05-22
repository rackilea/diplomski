bind(Parser.class)
        .annotatedWith(Names.named("x"))
        .to(ParserXImplementation.class);

bind(Parser.class)
        .annotatedWith(Names.named("y"))
        .to(ParserYImplementation.class);