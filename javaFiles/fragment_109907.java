Arrays.sort(fileArray, new Comparator<File>() {
    public int compare(File f1, File f2) {
        try {
            int i1 = Integer.parseInt(f1.getName());
            int i2 = Integer.parseInt(f2.getName());
            return i1 - i2;
        } catch(NumberFormatException e) {
            throw new AssertionError(e);
        }
    }
});