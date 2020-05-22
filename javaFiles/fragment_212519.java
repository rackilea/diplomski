import java.io.File;
import javax.mail.MessagingException;

public class A{

    File file;
    public void A() throws IOException{

     System.out.println("Sending the file...");
     file = new File("c:\\temp\\FileA.txt");
    }   
}