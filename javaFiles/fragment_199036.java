public static ArrayList<String> merge(ArrayList<String> L1, ArrayList<String> L2) {
    int i1 = 0, i2 = 0;
    ArrayList<String> result = new ArrayList<String>();

    while (i1 < L1.size() && i2 < L2.size()) {
        if (L1.get(i1).compareTo(L2.get(i2)) < 0) {
            result.add(L1.get(i1));
            i1++;
        } else {
            result.add(L2.get(i2));
            i2++;
        }
    }

    while (i1 < L1.size()) {
        result.add(L1.get(i1));
        i1++;
    }

    while (i2 < L2.size()) {
        result.add(L2.get(i2));
        i2++;
    }

    return result;
}