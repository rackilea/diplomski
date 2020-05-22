public static List<TockaXY> noviCentri(List<TockaXY> dataset, List<TockaXY> centers) {
    List<String> barve = new ArrayList<>();
    barve.add("Modra");
    barve.add("Rumena");
    barve.add("Zelena");
    barve.add("Rdeca");
    barve.add("Vijola");
    barve.add("Crna");
    barve.add("Oranzna");
    barve.add("Roza");
    barve.add("Rjava");
    barve.add("Siva");


    Map<String, TockaXY> barvniCluster = new IdentityHashMap<>(centers.size());
    for (int d = 0; d < centers.size(); d++) {
        barvniCluster.put(barve.get(d), centers.get(d));
    }