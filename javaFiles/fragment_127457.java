List<String> cities = new ArrayList<>(25);
    cities.add("D");
    cities.add("C");
    cities.add("B");
    cities.add("A");

    for (int i = 1; i < cities.size(); i++) {
        String key = cities.get(i);
        int j = i - 1;
        while ((j > -1) && (cities.get(j).compareToIgnoreCase(key) > 0)) {
            cities.set(j + 1, cities.get(j));
            j--;
        }
        cities.set(j + 1, key);
    }