Collections.sort(list, new Comparator<PlacedObject>() {

    @Override
    public int compare(PlacedObject po1, PlacedObject po2) {
        return Double.valueOf(po1.distance).compareTo(po2.distance);
    }
});