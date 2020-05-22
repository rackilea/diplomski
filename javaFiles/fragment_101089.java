List<Player> value = playerList.stream()
        .collect(groupingBy(Player::getScore))
        .entrySet()
        .stream()
        .max(Comparator.comparing(Map.Entry::getKey))
        .get()
        .getValue();