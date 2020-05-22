final Locale[] locales = Locale.getAvailableLocales();
    Optional<String> country2 = Stream.of(locales)
            .filter((loc) -> country1.equals(loc.getDisplayCountry(locale1)))
            .map((cloc) -> cloc.getDisplayCountry(locale2))
            .filter((s) -> !s.isEmpty())
            .findAny();
    System.out.println(country2.orElse("not found"));