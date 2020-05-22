Arrays.sort(listOfFiles, new Comparator<File>() {
    @Override
    public int compare(File f1, File f2) {
        String name1 = f1.getName();
        String name2 = f2.getName();
        if (name1.length() == name2.length())
            return f1.getName().compareTo(f2.getName());
        return name1.length() - name2.length();
    }
});