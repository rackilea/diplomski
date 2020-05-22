public void test(Consumer<Map<String, Object>> callback) {
    final Map<String, Object> yourMap = new HashMap<>();
    new BukkitRunnable() {
        @Override
        public void run() {
            yourMap.put("A", something);
            yourMap.put("B", 1.5);
            callback.accept(yourMap); //here the consumer gets the map
        }
    }.runTaskAsynchronously(bridge);
}