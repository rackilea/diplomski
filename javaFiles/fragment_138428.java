import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

JSch jsch = new JSch();
com.jcraft.jsch.Session session = null;
String result = "";

try {    
  session = jsch.getSession("user", "192.168.1.109", 22);
  session.setPassword("password");

  // Avoid asking for key confirmation
  Properties prop = new Properties();
  prop.put("StrictHostKeyChecking", "no");
  session.setConfig(prop);
  session.connect();

  // SSH Channel
  ChannelExec channel = (ChannelExec)session.openChannel("exec");
  ByteArrayOutputStream stream = new ByteArrayOutputStream();
  channel.setOutputStream(stream);

  // Execute command
  channel.setCommand("ls -ltr");
  channel.connect(1000);
  java.lang.Thread.sleep(500);   // this kludge seemed to be required.
  channel.disconnect();

  result = stream.toString();
}
catch (JSchException ex) {
  String s = ex.toString();
  System.out.println(s);
}
catch (InterruptedException ex) {
  String s = ex.toString();
  System.out.println(s);
}
finally {
  if (session != null)
    session.disconnect();
}