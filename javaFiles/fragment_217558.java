import com.sun.mail.smtp.*;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class javamail {

    // Piped Data Source

    private static class PipedDataSource  implements DataSource {
        InputStream in;
        String type;
        public PipedDataSource (InputStream in, String type) { this.in = in; this.type = type; }
        public String getContentType() { return type; }
        public InputStream getInputStream() { return in; }
        public String getName() { return "DataSource"; }
        public OutputStream getOutputStream() throws IOException { throw new IOException("No OutputStream"); }
    }

    // Main Method

    public static void main(String [] args) throws Exception {

        final int BUFFER_SIZE = 32768;

        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", System.getProperty("mail.smtp.starttls.enable","true"));
        properties.put("mail.smtp.ssl.trust", System.getProperty("mail.smtp.ssl.trust","*"));
        properties.put("mail.smtp.host", System.getProperty("mail.smtp.host","localhost"));
        properties.put("mail.smtp.port", System.getProperty("mail.smtp.port","587"));

        Session session = Session.getInstance(properties);

        String host = properties.getProperty("mail.smtp.host");
        int port = Integer.parseInt(properties.getProperty("mail.smtp.port"));
        System.err.println("connect: smtp://"+host+":"+port); System.err.flush();

        MimeMessage msg = new MimeMessage(session);

        PipedInputStream in = new PipedInputStream(BUFFER_SIZE);
        PipedOutputStream out = new PipedOutputStream(in);

        // Set general headers

        msg.setFrom(System.getProperty("mail.from","Unknown <unknown@example.com>"));
        msg.setRecipients(Message.RecipientType.TO, System.getProperty("mail.to", "unknown@example.com"));
        msg.setSentDate(new Date());
        msg.setSubject("JavaMail Test");
        msg.setHeader("X-Mailer", "JavaMail");

        // Set main text - Part 1 - content provided here
        MimeBodyPart part1 = new MimeBodyPart();
        StringBuilder sb = new StringBuilder();
        sb.append("This is the cover letter that describes the accompanying  \n");
        sb.append("attachment, which is a base64 encoded text document of  \n");
        sb.append("little more value than a demonstration.\n\n");
        part1.setText(sb.toString()); // Writes a computed Content-Type Header
        part1.setHeader("Content-Type","text/plain; charset=us-ascii; format=flowed; delsp=yes"); // Rewrite Header

        // Set attachment - Part 2 - content provdied from another thread via a pipe
        MimeBodyPart part2 = new MimeBodyPart();
        part2.setDataHandler(new DataHandler(new PipedDataSource (in, "text/html"))); // Writes a Content-Type Header
        part2.setHeader("Content-Type","text/plain; charset=\"utf-8\"; name=\"Lorem Ipsum.txt\""); // Rewrite Header
        part2.setHeader("Content-Disposition", "attachment; filename=\"Lorem Ipsum.txt\"");
        part2.setHeader("Content-Transfer-Encoding","base64");

        // Join parts
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(part1);
        multipart.addBodyPart(part2);
        msg.setContent(multipart);

        // Start thread to deliver content for Part 2 attachment via DataHandler
        Thread t = new Thread() {
            public void run() {
                try {
                    PrintWriter w = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
                    w.print("Lorem ipsum dolor sit amet, ligula suspendisse nulla pretium");
                    w.print(", rhoncus tempor fermentum, enim integer ad vestibulum volut");
                    w.print("pat. Nisl rhoncus turpis est, vel elit, congue wisi enim nun");
                    w.print("c ultricies sit, magna tincidunt. Maecenas aliquam maecenas ");
                    w.print("ligula nostra, accumsan taciti. Sociis mauris in integer, a ");
                    w.print("dolor netus non dui aliquet, sagittis felis sodales, dolor s");
                    w.print("ociis mauris, vel eu libero cras. Faucibus at. Arcu habitass");
                    w.print("e elementum est, ipsum purus pede porttitor class, ut adipis");
                    w.print("cing, aliquet sed auctor, imperdiet arcu per diam dapibus li");
                    w.print("bero duis. Enim eros in vel, volutpat nec pellentesque leo, ");
                    w.print("temporibus scelerisque nec.");
                    w.println("");
                    w.println("");
                    w.flush(); // Ensure data completely flushed to buffer
                    w.close(); // closes the writer and PipedOutputStream
                } catch(Exception e) { e.printStackTrace(); };
                try { out.close(); } catch(Exception e) { e.printStackTrace(); }
            }
        };
        t.start();

        // Send the message on its way
        SMTPTransport xp = (SMTPTransport) session.getTransport();
        xp.connect();
        xp.sendMessage(msg,msg.getAllRecipients());
        System.err.println(xp.getLastServerResponse());

        t.join();
        return;
    }
}