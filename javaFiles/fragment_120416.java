new Comparator<city>() {
    @Override
    public int compare(city city1, city city2) {
        return city1.getSLD() - city2.getSLD();
    }
};