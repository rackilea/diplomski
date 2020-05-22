class NameComparator implements Comparator<Name>{
    @Override
    public int compare(Name a, Name b) {
        return a.getFirstName().compareTo(b.getFirstName());    // ASC: a to b or DESC: b to a
    }
}