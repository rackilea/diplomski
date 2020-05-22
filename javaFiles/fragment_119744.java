class NameComparator implements Comparator<Name>{
    @Override
    public int compare(Name a, Name b) {
        return a.getLastName().compareTo(b.getLastName());  // ASC: a to b or DESC: b to a
    }
}