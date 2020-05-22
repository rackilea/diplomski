Comparator<String> comparator = new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        Date first;
        try {
            first = sdf.parse(o1);
        } catch (Exception ignored) {
            first = null;
        }
        Date second;
        try {
            second = sdf.parse(o2);
        } catch (Exception ignored) {
            second = null;
        }

        if (first == second) {
            return 0;
        }
        if (first == null) {
            return 1;
        }
        if (second == null) {
            return -1;
        }
        return first.compareTo(second);
    }
};