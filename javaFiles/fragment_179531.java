package stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("/absolute/path/to/your/yourconfigfile.properties");
        props.load(in);
        in.close();
        String filePath = props.getProperty("MyFilePATH", "WHATEVER-DEFAULT-VALUE-YOU WANT");
        System.out.println(filePath);
    }

}