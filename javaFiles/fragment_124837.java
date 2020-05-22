Optional<Map.Entry<LocalDate, List<String>>> first = map
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue().contains("Barry"))
            .sorted(Map.Entry.comparingByKey())
            .findFirst();