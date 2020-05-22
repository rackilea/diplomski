import java.io.File;

public class Encrypter {

    public static void main(String[] args) {
        Encrypter enc = new Encrypter();
        enc.traverseFileTree(new File("root directory or single File"));
    }

    private void traverseFileTree(File node) {
        if (node.isDirectory()) {
            for (String child : node.list()) {
                traverseFileTree(new File(node, child));
            }

            if (node.isFile()) {
                encrypt(node);
            }
        }
    }

    public void encrypt(File file) {

        // your encryption method
    }

}