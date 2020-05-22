final Iterator<String> mapItr = returnMap
                                  .values()
                                  .stream()
                                  .flatMap(Set::stream)
                                  .collect(Collectors.toList())
                                  .iterator();