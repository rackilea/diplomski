List<String> entries = x.getEntry.stream()
        .filter(Objects::nonNull)
        .map(Entry::getContent)
        .map(Content::getProperties)
        .map(Properties::getPostcodes‌)
        .flatMap(Pattern.co‌mpile(",")::splitAsS‌tream)
        .collect(Collectors.toList());