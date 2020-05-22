Comparator<Pair> cmp = Comparator.comparingLong(Pair::getMillis);

double diff = stream
    .skip(1)
    .map(Pair::new)
    .filter(pair -> (pair.getMillis() > startMillis) && (pair.getMillis() < endMillis))
    .collect(pairing(Collectors.maxBy(cmp), Collectors.minBy(cmp),
      (maxPair, minPair) -> maxPair.get().getKWhs() - minPair.get().getKWhs()));