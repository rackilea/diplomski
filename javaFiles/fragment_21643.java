HashMap<String, Integer> map = new HashMap<String, Integer>();

public void insert(String player, int scoreChange) {
    Integer value = map.get(player);
    if (value == null)
        value = 0;
    map.put(player, value + scoreChange)
}

public void getScore(String player) {
    Integer value = map.get(player);
    if (value == null)
        value = 0;
    return value;
}