DefaultPrettyPrinter pp = new DefaultPrettyPrinter()
            .withoutSpacesInObjectEntries()
            .withArrayIndenter(new DefaultPrettyPrinter.NopIndenter());

ObjectWriter w = new ObjectMapper()
            .writer()
            .with(pp);