package ta_aing;

import com.mysql.jdbc.PreparedStatement;
import java.util.*;
import javax.mail.*;
import java.sql.Connection;
import java.sql.Statement;
import ta_aing.connection;
/**
 *
 * @author Yoas
 */
public class cobaaaaa {


    public static void main(String[] args) {
        Properties props = new Properties();
        connection datMan = new connection();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "email", "password");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            System.out.println(inbox.getMessageCount());
            Message [] msg = inbox.getMessages();


            Connection conn;
            conn = datMan.logOn();

            for (int c=0;c<msg.length;c++){
                Address[] in = msg[c].getFrom();

            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            Multipart mp = (Multipart) msg[c].getContent();
            BodyPart bp = mp.getBodyPart(0);
            System.out.println("SENT DATE:" + msg[c].getSentDate());
            System.out.println("SUBJECT:" + msg[c].getSubject());
            System.out.println("CONTENT:" + bp.getContent());

            Statement st;

            st = (Statement) conn.createStatement();

            for(int i = 0;i<in.length;i++){
                st.executeUpdate("insert into email values(null,'"+in[i].toString()+"','"+msg[c].toString()+"','"+msg[c].getSubject()+"','"+bp.getContent()+"')");
            }

            }

            conn.close();

        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
}