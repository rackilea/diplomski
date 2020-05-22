Set<String> titleExclusions = ResourceUtility.contentToUtf8TreeSet("+.txt")
                                             .stream()
                                             .filter(item -> !item.isEmpty())
                                             .collect(Collectors.toSet());
// uses titleExclusions 
boolean noMatches = titleExclusions.stream()
                                   .noneMatch(tittle::contains);
// uses titleExclusions again.