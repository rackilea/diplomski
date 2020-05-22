Map<Document, List<Document>> map = documents.stream()
    .collect(Collectors.toMap(                                // Collected to Map<Document, List<Document>>
        Function.identity(),                                  // Document is the key
        d1 -> documents.stream()                              // Value are the qualified documents
            .filter(d2 -> !d1.equals(d2) &&            
                utils.matchesOnCriteria(d1,d2, userCriteria)
            .collect(Collectors.toList())));                  // ... as List<Document>

Set<Pair<Document>> matches = map.entrySet().stream().reduce( // Reduce the Entry<Dokument, List<Document>>
    new HashSet<>(),                                          // ... to Set<Pair<>>
    (set, e) -> {
        set.addAll(e.getValue().stream()                      // ... where is
            .map(v -> new Pair<Document>(e.getKey(), v))      // ... the Pair of qualified documents
            .collect(Collectors.toSet()));                   
        return set;
    },
    (left, right) -> { left.addAll(right); return left; });   // Merge operation