incoming.stream()
        .filter(dict::contains)
        .forEach(spelledCorrectly::add);

incoming.stream()
        .filter(e -> !e.isEmpty() && !dict.contains(e.toLowerCase()))
        .forEach(misspelled::add);