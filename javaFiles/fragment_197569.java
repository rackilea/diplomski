import java.io.*;

public class Data {

    public static void main(String[] args) throws IOException {
        String target_dir = "C:\\Files";
        String textfile;
        File dir = new File(target_dir);
        File[] files = dir.listFiles();

        for (File textfiles : files) {
            if (textfiles.isFile() && textfiles.getName().endsWith(".txt")) {

                BufferedReader inputStream = null;

                try {
                    inputStream = new BufferedReader(new FileReader(textfiles));
                    String line;

                    while ((line = inputStream.readLine()) != null) {
                        System.out.println(line);
                    }
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
    }
}