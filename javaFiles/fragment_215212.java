package mod8;
import mod8.Tail;
import java.net.*;
import java.io.*;
import java.util.*;

public class CaptureURI  {


    public static boolean isLocalFile(String file) {
        try {
            new URL(file);
            return false;
        } catch (MalformedURLException e) {
            return true;
        }
    }


    public static String CURI(String uri, Integer lines) throws IOException {
        String out = "";

        // Get the entire file/URI
        if(lines == 0){     
            if(isLocalFile(uri)){
                try {
                     out = new Scanner(new File(uri)).useDelimiter("\\Z").next();               
                } 
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else{
            Scanner scanner = new Scanner(new URL(uri).openStream(), "UTF-8");
            out = scanner.useDelimiter("\\A").next();
            scanner.close();
            }
        }

        //Take "head" lines of file/URI
        if(lines > 0){
            if(isLocalFile(uri)){
                try {
                    File file = new File(uri);                      
                    Scanner s = new Scanner(file);
                    for(int i = 0; i < lines; i++)
                        {
                        out += s.nextLine();
                        }
                    s.close();
                } 
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else{
            Scanner scanner = new Scanner(new URL(uri).openStream(), "UTF-8");
            for(int i = 0; i < lines; i++) 
            {
                out += scanner.next();
            }
            scanner.close();
            }

        }

        // Take "tail" lines of file/URI
        if(lines < 0){
            if(isLocalFile(uri)){
                try {
                    File file = new File(uri);            
                    Scanner s = new Scanner(file);
                    out = s.toString();
                    //String[] ary = out.split("");
                    out = Tail.JavaTail(out);
                    s.close();
                } 
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else{
            Scanner scanner = new Scanner(new URL(uri).openStream(), "UTF-8");
            for(int i = 0; i < lines; i++) 
            /*{
                out += scanner.next();
            }*/
            out = Tail.JavaTail(out);   
            scanner.close();
            }

        }


        return(out);
    }
}