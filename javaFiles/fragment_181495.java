import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.apache.log4j.net.SMTPAppender;

/**
* @author DEV
*
*/
public class GmailAppender extends SMTPAppender {
private boolean startTLS = false;

@Override
protected Session createSession() {
Properties props = null;
try {
props = new Properties(System.getProperties());
} catch (SecurityException ex) {
props = new Properties();
}
String prefix = "mail.smtp";
if (this.getSMTPProtocol() != null) {
props.put("mail.transport.protocol", this.getSMTPProtocol());
prefix = "mail." + this.getSMTPProtocol();
}

if (this.getSMTPHost() != null)
props.put(prefix + ".host", this.getSMTPHost());
if (this.getSMTPPort() > 0)
props.put(prefix + ".port", String.valueOf(this.getSMTPPort()));
if (this.startTLS)
props.put("mail.smtp.starttls.enable", "true");

Authenticator auth = null;
if (this.getSMTPPassword() != null && this.getSMTPUsername() != null) {
props.put(prefix + ".auth", "true");
auth = new Authenticator() {
...