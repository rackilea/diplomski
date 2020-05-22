public static void tripsInConfigurableOrder() {
    Map<String, Integer> mp = new HashMap<String, Integer>();

    mp.put("Delhi", 1);
    mp.put("Bombay", 1);
    mp.put("Bangalore", 1);

    int numberOfTrips = 5;
    List<String> orderOfVisits = Arrays.asList("Delhi", "Bombay", "Bangalore");
    Iterator<String> visiterator = orderOfVisits.iterator();

    for (int i = 0; i < numberOfTrips; i++) {
        if (!visiterator.hasNext()) {
            visiterator = orderOfVisits.iterator();
        }

        String key = visiterator.next();
        mp.put(key, mp.get(key) + 1);
    }

    for (Entry<String, Integer> entry : mp.entrySet()) {
        System.out.println("Key:" + entry.getKey() + ", Value:" + entry.getValue());
    }
}

public static void tripsInNaturalOrder() {
    Map<String, Integer> mp = new LinkedHashMap<>();

    mp.put("Delhi", 1);
    mp.put("Bombay", 1);
    mp.put("Bangalore", 1);

    int numberOfTrips = 5;
    Iterator<String> visiterator = mp.keySet().iterator();

    for (int i = 0; i < numberOfTrips; i++) {
        if (!visiterator.hasNext()) {
            visiterator = mp.keySet().iterator();
        }

        String key = visiterator.next();
        mp.put(key, mp.get(key) + 1);
    }

    for (Entry<String, Integer> entry : mp.entrySet()) {
        System.out.println("Key:" + entry.getKey() + ", Value:" + entry.getValue());
    }
}

public static void usingComparator() {
    Map<String, Integer> mp = new TreeMap<>(Comparator.naturalOrder());

    mp.put("Delhi", 1);
    mp.put("Bombay", 1);
    mp.put("Bangalore", 1);

    int numberOfTrips = 5;
    Iterator<String> visiterator = mp.keySet().iterator();

    for (int i = 0; i < numberOfTrips; i++) {
        if (!visiterator.hasNext()) {
            visiterator = mp.keySet().iterator();
        }

        String key = visiterator.next();
        mp.put(key, mp.get(key) + 1);
    }

    for (Entry<String, Integer> entry : mp.entrySet()) {
        System.out.println("Key:" + entry.getKey() + ", Value:" + entry.getValue());
    }
}

public static void main(String[] args) {
    tripsInConfigurableOrder();
    tripsInNaturalOrder();
    usingComparator();
}