List<String> matches=IntStream.range(0, words.size())
    // find matches
    .filter(ix->words.get(ix).matches(word))
    // create subLists around the matches
    .mapToObj(ix->words.subList(Math.max(0, ix-1), Math.min(ix+2, words.size())))
    // reconvert lists into phrases (join with a single space
    .map(list->String.join(" ", list))
    // collect into a list of matches; here, you can use a different
    // terminal operation, like forEach(System.out::println), as well
    .collect(Collectors.toList());