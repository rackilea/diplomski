File dir = new File("some/path/to/dir");
final String id = "XXX"; // needs to be final so the anonymous class can use it
File[] matchingFiles = dir.listFiles(new FileFilter() {
    public boolean accept(File pathname) {
        return pathname.getName().equals("a_id_" + id + ".zip");
    }
});