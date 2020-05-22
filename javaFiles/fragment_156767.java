final SortedMap<Integer, String> result = myScs.stream()
     .map(t -> (SpecialSequenceContainer) t)
     .collect(SequenceContainer::getSequence, 
              SpecialSequenceContainer::t2OwnMethod, 
              (s1, s2) -> s1, 
              TreeMap::new);