public class TempFile2 {

    private File file;
    private File tempFile;
    private FileOutputStream os;

    public TempFile2(File file) {
        this.file = file;
        this.tempFile = new File(file.getParent(), FilenameUtils.getBaseName(file.getName()) + ".tmp");
        if (!tempFile.exists()) {
            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            os = new FileOutputStream(tempFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addEntry(byte[] data, int count) {

        try {
            os.write(data, 0, count);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeFile() {

        try {
            os.close();
            Files.copy(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}