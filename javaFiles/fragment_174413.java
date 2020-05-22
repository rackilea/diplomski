import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileReplace {
    ArrayList<String> lines = new ArrayList<String>();
    String line = null;

    public void doIt() {
        File f1=null;
        FileReader fr=null;
        BufferedReader br=null;
        FileWriter fw=null;
        BufferedWriter out=null;
        try {
            f1 = new File("src/test.xml");
            fr = new FileReader(f1);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains("&#x7c;"))
                    line = line.replace("&#x7c;", "|");
                lines.add(line);
            }

            fw = new FileWriter(f1);
            out = new BufferedWriter(fw);
            for (String s : lines)
                out.write(s);
            out.flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try{
            fr.close();
            br.close();
            out.close();
            }catch(IOException ioe)

            {
                ioe.printStackTrace();
            }
        }

    }

    public static void main(String args[]) {
        FileReplace fr = new FileReplace();
        fr.doIt();
    }
}