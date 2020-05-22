List<Country> items = new ArrayList<Country>();

.....
Collections.sort(items, new Comparator<Country>() {

    @Override
    public int compare(Country o1, Country o2) {
        return Double.compare(o1.getDistance(), o2.getDistance());
    }

});