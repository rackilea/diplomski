import java.io.*;
import java.util.*;
import static java.lang.System.out;
public class ReadReg {
    public static void main(String[] argv){
        String line=null; StringBuilder sb = new StringBuilder();
        Scanner scanner; 
        FileOutputStream fos; 
        BufferedOutputStream bos; OutputStreamWriter fosw;
        try {
            scanner = new Scanner(new File("hklm-hw.txt"), "UTF-16");
            fos  = new FileOutputStream("hklm-hw.cat.txt");
            bos  = new BufferedOutputStream(fos);
            fosw = new OutputStreamWriter(bos, "UTF-16");
            while (scanner.hasNextLine()) {
                sb.append( line = scanner.nextLine());
                if (line.isEmpty()) {
                    sb.append("\n");
                }
            }
            if (null != scanner.ioException()) {
                out.format("scanner ioe:\n\t%s\n", scanner.ioException().getMessage());
                //scanner.ioException().printStackTrace();
            }
            fosw.write( sb.toString(), 0, sb.length());
            fosw.flush();
            fosw.close();
            scanner.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}