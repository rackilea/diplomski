Collections.sort(letters, new Comparator<BoxLetter>() {
    @Override
    public int compare(BoxLetter a, BoxLetter b) {
        int cmp = Integer.compare(a.getCentroid().y, b.getCentroid().y);
        if (cmp != 0) {
            return cmp;
        }
        return Integer.compare(a.getCentroid().x, b.getCentroid().x);
    }
}