static boolean isValid(final File file) {
    ZipFile zipfile = null;
    try {
        zipfile = new ZipFile(file);
        return true;
    } catch (IOException e) {
        return false;
    } finally {
        try {
            if (zipfile != null) {
                zipfile.close();
                zipfile = null;
            }
        } catch (IOException e) {
        }
    }
}