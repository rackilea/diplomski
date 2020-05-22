public static class ReadEventFile {

    private final File eventFile;
    private final int count;

    public ReadEventFile(final int count, final File eventFile) {
        this.eventFile = eventFile;
        this.count = count;
    }

    public String[] openFile() throws IOException {
        String[] dataTable = new String[count];
        int i;
        for (i = 0; i < count; i++) {
        }
        return dataTable;
    }
}