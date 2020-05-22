import java.io.*;
import javax.swing.*;
import java.util.Vector;

class ReadFile {

    public static void main(String [] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File ("ReadFile.java");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            // normally I would prefer to use an ArrayList, but JList
            // has a constructor that takes a Vector directly.
            Vector<String> lines = new Vector<String>();

            String line;
            while((line=br.readLine())!=null) {
                System.out.println(line);
                lines.add(line);
            }

            JOptionPane.showMessageDialog(null, new JScrollPane(new JList(lines)));
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if( null != fr ) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}