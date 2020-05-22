import java.io.*;

public class CreateXML {
    public static void main(String[] args) throws Exception {
        FileWriter fstream = new FileWriter(new File("split.xml"));
        BufferedWriter out = new BufferedWriter(fstream);
        out.write("<root>");
        for (int i = 0; i < 1000; i++) {
            out.write("<envelope fileID=\"000" + i +"P.XML\"><record id=\"" + i + "\"></record></envelope>\n");
        }
        out.write("</root>");
        out.close();
    }
}