new Comparator<File>() {
    private final Comparator<String> NATURAL_SORT = new WindowsExplorerComparator();

    @Override
    public int compare(File o1, File o2) {;
        return NATURAL_SORT.compare(o1.getName(), o2.getName());
    }
}