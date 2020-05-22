public class Main {

    public static void main(String[] args) {
        Path path = Paths.get("c:/users");
        MyFileVisitor fileVisitor = new MyFileVisitor();
        try {
            Files.walkFileTree(path, fileVisitor);
            System.out.println(fileVisitor.getDirCount() + " directories");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}