public List<Coin> groupedCoins(List<Coin> coins) {
    return new ArrayList<>(
            coins.stream()
                    .collect(Collectors.toMap(
                            coin -> Arrays.asList(coin.getType(), coin.getFaceValue()), Function.identity(),
                            (coin1, coin2) -> {
                                BigInteger netQ = coin1.getQuantity().add(coin2.getQuantity());
                                return new Coin(coin1.getType(), coin1.getFaceValue(), netQ);
                            }))
                    .values());
}