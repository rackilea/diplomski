public void changeAmount(String key, int amount) {
    item temp = items.get(key);
    items.remove(key);
    temp.setAmount(amount);
    items.put(key, temp);
}