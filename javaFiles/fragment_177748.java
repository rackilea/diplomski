public class FilePathChanger {
    public static void main(String[] args) {
        String filePath = "D:\\Folder\\subfolder";
        filePath = filePath.replace("\\", "\\\\");
        System.out.println(filePath);
    }
}