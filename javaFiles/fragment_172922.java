public class Program {

    public static void main(String args[]) throws IOException {
        search(new File("."), 0);
    }

    public static void search(File file, int level) {
        if (!file.isDirectory()) {
            return;
        }

        for (File f : file.listFiles()) {
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(f.getName());
            if (f.isDirectory()) {
                search(f, ++level);
            }
        }
    }
}