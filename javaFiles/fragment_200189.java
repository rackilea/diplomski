public void SaveZipFiles(File destwithouAudio) { 
    File[] deletion = destwithouAudio.listFiles(new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
            return !name.endsWith(".zip");
        }

    });
    for (File toDelete : deletion) {
        deleteDir(toDelete);
    }
}