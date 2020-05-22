List<CurrencyItem> currenciesByCommercialBank = new ArrayList<>();
    List<CurrencyItem> currenciesByCentralBank = new ArrayList<>();
    // Build my lookup from CurrencyName to CommercialBank.
    Map<CurrencyName, CurrencyItem> commercials = currenciesByCommercialBank
            .stream()
            .collect(
                    Collectors.toMap(
                            // Map from currency name.
                            ci -> ci.getName(),
                            // To the commercial bank itself.
                            ci -> ci));
    Map<CurrencyItem, CurrencyItem> commercialToCentral = currenciesByCentralBank
            .stream()
            .collect(
                    Collectors.toMap(
                            // Map from the equivalent commercial
                            ci -> commercials.get(ci.getName()),
                            // To this central.
                            ci -> ci
                    ));