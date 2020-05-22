for (ArrayList<List<String>> row2 : StatspH) {
    List<String> stats = row2.get(1);

    // remove() returns the object that was removed
    String allStats = stats.remove(0);

    Collections.addAll(stats, allStats.split("\\s"));
}