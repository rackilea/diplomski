private static ArrayList<ArrayList<Integer>> unique(ArrayList<Integer> a, ArrayList<Integer> b) {
    ArrayList<ArrayList<Integer>> unique = new ArrayList<>();

    unique.add(new ArrayList<>());
    unique.add(new ArrayList<>());


    for (Integer i: a) {
        if (!b.contains(i) && !unique.get(0).contains(i)) {
            unique.get(0).add(i);
        }
    }

    for (Integer i: b) {
        if (a.contains(i) && !unique.get(1).contains(i)) {
            unique.get(1).add(i);
        }
    }

    return unique;
}