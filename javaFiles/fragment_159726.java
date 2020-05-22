players.stream()
       .collect(Collectors.groupingBy(
           Player::getPoints,
           TreeMap::new,
           Collectors.toList()
       ))
       .lastEntry()
       .getValue();