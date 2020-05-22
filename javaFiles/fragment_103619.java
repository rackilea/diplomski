int maxPrize = arrRoundarrRound.stream()                      // Stream<Round>
                               .map(Round::getHits)           // Stream<List<Hits>>
                               .flatMap(List::stream)         // Stream<Hits>
                               .mapToInt(Hit::getPrizeAmount) // IntStream
                               .max()                         // OptionalInt 
                               .orElse(-1);                   // int