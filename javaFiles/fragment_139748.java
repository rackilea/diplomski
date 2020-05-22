final Map<CompareAttribute, Collection<ObjectAttributesValueContainer>> 
  differentObjectsForAttributes = 
  differences
        .entrySet()
        .stream()
        .flatMap((entry) -> 
                   entry.getValue() // Set<CompareAttribute>
                   .stream()
                   .map((attr) -> {return new ImmutablePair<ObjectAttributesValueContainer,CompareAttribute>
                                                            (entry.getKey(), attr);}
                 ))
        // now we have a stream of ImmutablePair<ObjectAttributesValueContainer,CompareAttribute>
         .collect(Collectors.toMap(Pair::getValue, 
                                   (pair) -> {return new HashSet<ObjectAttributesValueContainer>
                                                               (Collections.singleton(pair.getKey()));
                                             }, 
                                   (a1, a2) -> {a1.addAll(a2);
                                                return a1;
                                               }
                                   ));