import java.io.*;

public class tmp {
    public static void main(String[] args) throws IOException {
        File folder = new File(System.getProperty("user.dir"));
        File[] files = folder.listFiles();

        for(int i = 0; i < files.length; i++) {
            if(files[i].isFile()) {
                String name = files[i].getName();
                if(name.indexOf("-") != -1) {
                    System.out.println(name);
                    name = name.substring(0, name.indexOf("-"));
                    new File(System.getProperty("user.dir") + "/" + name + "/").mkdirs();
                    files[i].renameTo(new File(System.getProperty("user.dir") + "/" + name + "/" + files[i].getName()));
                }
            }
        }

    }
}