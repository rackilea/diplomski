Collections.sort(list, new Comparator<List<String>>() {
    @Override
    public int compare(List<String> o1, List<String> o2) {
        int retVal = Integer.compare(getIntByIndex(o1, 2), getIntByIndex(o2, 2));
        if (retVal != 0) {
            return retVal;
        }

        retVal = Integer.compare(getIntByIndex(o1, 1), getIntByIndex(o2, 1));
        if (retVal != 0) {
            return retVal;
        }

        return Integer.compare(getIntByIndex(o1, 0), getIntByIndex(o2, 0));
    }

    private int getIntByIndex(List<String> sublist, int index) {
        return Integer.parseInt(sublist.get(index));
    }
});