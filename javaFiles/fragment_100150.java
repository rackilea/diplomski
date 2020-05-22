Collections.sort(dogs, new Comparator<Dog>() {
    @Override
    public int compare(Dog d1, Dog d2) {
        return d1.compareTo(d2); // Call the Comparable method
    }
)};