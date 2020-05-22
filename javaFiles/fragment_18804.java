Collections.sort(myCubes, new Comparator()) {
    @Override
    public int compare(Cube c1, Cube c2) {
        return new Integer(c1.getPosition()).compareTo(new Integer(c2.getPosition()));
    }
}