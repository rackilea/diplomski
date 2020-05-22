String[] places = {"Bangalore","Pune","San Francisco","New York City"};

Comparator<String> c = new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
};
Arrays.sort(places, c);
System.out.println(Arrays.binarySearch(places, "New York City", c));