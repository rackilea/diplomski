import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileCopy { 
public static void main(String[] args) throws IOException { 
    Scanner s=new Scanner(System.in); 
    FileReader fr = null; 
    FileWriter fw = null; 
    try { 
        System.out.println("enter a source file which exists"); 
        String file1=s.next(); 
        fr = new FileReader(file1); 
        System.out.println("enter a destination file"); 
        String file2=s.next();

        File f2=new File(file2); 
        if(!f2.exists()) { 
            fw = new FileWriter(file2); 
            f2.createNewFile(); 
            int c = fr.read(); 
            while(c!=-1) { 
                fw.write(c); 
                c = fr.read(); 
            } 
            fr.close();
            System.out.println("file copied successfully"); 
        } else { 

            System.out.println("do you want to overwrite? enter 'yes' or 'no'..."); 
            char ans = s.next().charAt(0);

            if(ans=='N'||ans=='n') { 
                fr.close();
            //  fw.close();
                System.out.println("couldnot enter data"); 
            } else { 
                  fw = new FileWriter(file2); 
                int c = fr.read(); 
                while(c!=-1) { 
                    fw.write(c); 
                    c = fr.read(); 
                } 
                fr.close();
                System.out.println("file updated successfully"); 
            } 
        } 
    } catch(IOException e) { 
        System.out.println("file coudn't be found"); 
    } finally { 
        close(fr); 
        close(fw); 
        //fw.close();
    } 
} 
public static void close(Closeable stream) { 
    try { 
        if (stream != null) { 
            stream.close(); 
        } 
    } catch(IOException e) { //... 
        e.printStackTrace();
        } 
    }
}