package javawhitelist;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaWhiteListExample {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in); 
        String directoryName = "Bob"; 
        String filePath = null; 
        FileWriter stream = null;
        String text = "some text";  
        System.out.print("Enter a file to write to: "); 
        filePath = scanner.nextLine();  
        String WHITELIST = "[^0-9A-Za-z]+";
        Pattern p = Pattern.compile(WHITELIST);
        Matcher m = p.matcher(filePath);

        //You need to do m.find() because m.matches() looks for COMPLETE match
        if(m.find()){ 
            //reject input.
            System.out.println("Invalid input.");
        }else{
            // Write to the file in Bob's home directory (i.e. Bob/textfile.txt) 
            try{
                File toWrite = new File(directoryName + File.separator + filePath);

                if(toWrite.canWrite()){
                    stream = new FileWriter(toWrite);
                    stream.write(text);
                }   
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                if(stream != null){
                    stream.close();
                }
            }

        }
    }
}