public static void main(String... args) throws NoSuchMethodException, IllegalAccessException {
    for (int i = 0; i < 4; i++) {
        long used1 = usedMemory();
        populate(new HashMap());
        long used2 = usedMemory();
        populate(new ConcurrentHashMap());
        long used3 = usedMemory();
        System.out.println("The ratio of used memory is " + (double) (used3 - used2) / (used2 - used1));
        System.out.println("For an extra " + ((used3 - used2) - (used2 - used1)) / 1000000 + " bytes per entry was used.");
    }
}

private static void populate(Map map) {
    for (Integer i = 0; i < 1000000; i++)
        map.put(i, i);
}

private static long usedMemory() {
    return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
}