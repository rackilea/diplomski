String[] timeAmountStrings = { "1m", "5M", "3D", "30m", "2h", "1Y", "3W" };
    LocalDateTime base = LocalDateTime.of(2019, Month.MARCH, 1, 0, 0);
    for (String tas : timeAmountStrings) {
        TemporalAmount amount = parse(tas);
        System.out.println("String: " + tas + " parsed: " + amount + " added: " + base.plus(amount));

        try {
            System.out.println("Added to Instant: " + Instant.EPOCH.plus(amount));
        } catch (DateTimeException dte) {
            System.out.println("Adding to Instant didn’t work: " + tas + ' ' + dte);
        }

        System.out.println();
    }