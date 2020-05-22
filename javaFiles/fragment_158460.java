public class MyFileFilter implements FileFilter{

    public boolean accept(File pathname) {
        return fileNamePattern.matcher(pathname.getName()).find();
    }

}