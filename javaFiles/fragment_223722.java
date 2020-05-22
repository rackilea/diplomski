Map<int[], String> treeMap = new TreeMap<>((o1, o2) -> {
        for (int i = 0; i < o1.length; i++) {
            if (o1[i] > o2[i]) {
                return 1;
            } else if (o1[i] < o2[i]) {
                return -1;
            }
        }

        return 0;
    });