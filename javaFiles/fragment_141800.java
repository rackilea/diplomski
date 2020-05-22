List<Locale> locales = Arrays.asList(new Locale("en"),
                                         new Locale("es"),
                                         new Locale("fr"),
                                         new Locale("es", "MX"),
                                         new Locale("zh"),
                                         new Locale("ja"));
    List<Locale.LanguageRange> ranges = Locale.LanguageRange.parse("da,es-MX;q=0.8");
    Locale best = Locale.lookup(ranges, locales);
    System.out.println("best = " + best); // prints best = es_MX

    ranges = Locale.LanguageRange.parse("fr,es-MX;q=0.8");
    best = Locale.lookup(ranges, locales);
    System.out.println("best = " + best); // prints best = fr