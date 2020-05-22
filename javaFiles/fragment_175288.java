public class TempFile2 {

    private File file;
    private File tempFile;

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

    }

    public void addEntry(byte[] data, int count) {
        try(OutputStream os = new FileOutputStream(tempFile, true)) {
            os.write(data, 0, count);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeFile() {

        try {
            Files.copy(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}