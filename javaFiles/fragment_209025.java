int[] a = { 1, 2, 3, 4 };
        Set<Integer> set = new HashSet<>();
        for (int value : a) {
            set.add(value);
        }
        for (Integer i : set) {
            System.out.println(i);
        }