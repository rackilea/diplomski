import org.apache.commons.mail.*;
public class EmailTest {
    public static void main(String[] args) {
        try {
            Email email = new SimpleEmail();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("emailid@gmail.com",
                    "yourPassword"));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom("emailid@gmail.com");
            email.setSubject("Hi");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("senderId@yahoo.co.in");
            email.setTLS(true);
            email.send();
            System.out.println("Mail sent!");
        } catch (Exception e) {
            System.out.println("Exception :: " + e);
        }
    }
}