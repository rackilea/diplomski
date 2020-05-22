private static Comparator<String> sizeComparator = new Comparator<String>() {

    private Map<String,Integer> sizes = new HashMap<>();
    {
        int i=0;
        for (String size : new String[]{"XS", "S", "M", "L", "XL", "XXL"}){
            sizes.put(size,i++);
        }
    }

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(sizes.get(o1),sizes.get(o2));
    }

};