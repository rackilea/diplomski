Collections.sort(priceArray, new Comparator<String>() {
    @Override
    public int compare(String p1, String p2) {
        String first = p1.substring(p1.lastIndexOf('$')+1);
        String second = p2.substring(p2.lastIndexOf('$')+1);
        System.out.println(first);
        System.out.println(second);
        return (int) (Double.parseDouble(first)-Double.parseDouble(second));
    }
});