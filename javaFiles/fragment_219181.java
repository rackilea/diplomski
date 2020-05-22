public class BagOfWords {

ConcurrentHashMap<String, Set<String>> map = new ConcurrentHashMap<String, Set<String>>();

public static void main(String[] args) throws IOException {
    File file = new File("F:/Downloads/Build/");
    new BagOfWords().iterateDirectory(file);
}

private void iterateDirectory(File file) throws IOException {
    for (File f : file.listFiles()) {
        if (f.isDirectory()) {
            iterateDirectory(file);
        } else {
            // Read File
            // Split and put it in a set
            // add to map
        }
    }
}