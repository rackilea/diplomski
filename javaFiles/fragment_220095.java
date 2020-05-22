import java.io.*;

public class CodeWritingDemo {

    public static void main(String[] args) throws Exception {
        String rootFolder = "src/res/"; // or args[0]
        File folder = new File(rootFolder);
        for (File file : folder.listFiles()) {
        if (file.getName().toLowerCase().endsWith("png") ||     file.getName().toLowerCase().endsWith("jpg")) {
                printFilename(file, "src/".length());
            }
        }
    }

    public static void printFilename(File file, int stripIndex) {
        String variableName = file.getName().replaceAll("[.]", "_");
        String template = "ImageIcon " + variableName + " = new ImageIcon(\"" + file.getPath().substring(stripIndex) + "\")";
        System.out.println(template);
    }
}