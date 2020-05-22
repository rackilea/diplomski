public static File[] findFilesForId(File dir, final String id) {
    return dir.listFiles(new FileFilter() {
        public boolean accept(File pathname) {
            return pathname.getName().equals("a_id_" + id + ".zip");
        }
    });
}