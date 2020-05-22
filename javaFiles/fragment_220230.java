import java.io.File;

class Test {
    public static void main(String[] args) {
        File[] drives = File.listRoots();
        if (drives != null && drives.length > 0) {
            for (File aDrive : drives) {
                System.out.println(aDrive);
            }
        }
    }
}