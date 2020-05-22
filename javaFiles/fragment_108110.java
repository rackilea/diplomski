public static void stutter(ArrayList<String> thing, int k) {
    if (k <= 0) {
        thing.clear(); // if k is 0
        return;
    }

    ArrayList<String> newList = new ArrayList<>();
    for (int i = 0; i< thing.size(); i++) {
        String temp = thing.get(i);
        for (int j = 0; j < k; j++) {
            newList.add(temp);
        }
    }
    thing.clear();
    thing.addAll(newList);
}