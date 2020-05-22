public static int getHorizontal(final List<List<Integer>> list, final int len) {
        List<Integer> sums = new ArrayList<Integer>(list.get(0));
        for (int i = 1; i < len; ++i)
            for (int j = 0; j < len; ++j)
                sums.set(j, sums.get(j) + list.get(i).get(j));
        return Collections.max(sums);
    }