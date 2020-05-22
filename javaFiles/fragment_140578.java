Integer[] numbers = new Integer[] { 21, null, 23, 24, 25, 26, 27, 28,
        29, 30, 31, 32, 33, 34, 35, 36 };

ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(numbers));

Collections.sort(list, new Comparator<Integer>() {
    @Override
    public int compare(Integer arg0, Integer arg1) {

        if (arg0 == null || arg1 == null)
            return 0;
        return arg0 - arg1;

    }
});