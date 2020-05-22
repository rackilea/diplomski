public class PathTest {

    public boolean pathAccessible(String path) {
        File file = new File(path);
        if (!file.isDirectory())
               file = file.getParentFile();
        return file.exists();

    }

}