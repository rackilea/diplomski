import java.io.*;
class Demo {
    public static void main( String [] args ) {
        try { 
            BufferedReader in = new BufferedReader(new FileReader("youFile.txt")); 
            String str; 
            while ((str = in.readLine()) != null) { 
                System.out.println( str ); 
            } 
            in.close(); 
        } catch (IOException e) {}     
    }
}