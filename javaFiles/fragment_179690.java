public class FindFiles {
    public void find(File src, File target) {
        assert(src.isDirectory() && target.isDirectory());
        try {
            File[] fileList = src.listFiles();

            ChangeColor change = new ChangeColor();

            for (File file : fileList) {
                if (file.isFile()) {
                    change.ChangeC(file, target);
                } else if (file.isDirectory()) {
                    // create the File object for the directory name
                    File newDir = new File(target, file.getName());
                    newDir.mkdir();
                    find(file, newDir);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FindFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}