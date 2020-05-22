File directory = new File(*String for absolute path to directory*);
File[] files = directory.listFiles();

Arrays.sort(files, new Comparator<File>() {

    @Override
    public int compare(File f1, File f2) {

        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
    }
});

file[0].delete();