Map<String, String> formattedDates = Map.of(
            "MM dd yy", "8 12 2019",
            "dd MM yy", "4 5 2007",
            "yy dd MM", "2001 10 8");

    for (Map.Entry<String, String> e : formattedDates.entrySet()) {
        String formatPattern = e.getKey();
        // Allow any number of digits for each of year, month and day of month
        formatPattern = formatPattern.replaceFirst("y+", "y")
                .replace("dd", "d")
                .replace("MM", "M");
        DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern(formatPattern);
        LocalDate date = LocalDate.parse(e.getValue(), sourceFormatter);
        System.out.format("%-11s was parsed into %s%n", e.getValue(), date);
    }