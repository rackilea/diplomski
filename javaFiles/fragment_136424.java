Arrays.sort(listOfFiles, new Comparator<File>() {
    @Override
    public int compare(File f1, File f2) {
        return f1.getName().compareTo(f2.getName());
    }
});