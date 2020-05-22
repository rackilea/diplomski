public List<Coin> groupedAndSummedCoins(List<Coin> coins) {
    return coins.stream()
            .collect(Collectors.groupingBy(Coin::getType,
                    Collectors.groupingBy(Coin::getFaceValue,
                            Collectors.reducing(BigInteger.ZERO, Coin::getQuantity, BigInteger::add))))
            .entrySet()
            .stream()
            .flatMap(e -> e.getValue().entrySet().stream()
                    .map(a -> new Coin(e.getKey(), a.getKey(), a.getValue())))
            .collect(Collectors.toList());
}