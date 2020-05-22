Comparator<String> comparator = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        // Get the index of both strings from the `order` string.
        // Lesser index means comes before.
        return order.indexOf(s1) - order.indexOf(s2);
    }
};

Arrays.sort(arr, comparator);