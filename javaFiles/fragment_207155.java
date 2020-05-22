import com.jcraft.jsch.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        OutputStream out = null;
        Session session = null;
        try {
            JSch jsch = new JSch();
            String user = "sshuser";
            String host = "localhost";
            session = jsch.getSession(user, host, 22);
            String passwd = "password";
            session.setPassword(passwd);
            session.setConfig("StrictHostKeyChecking", "no");

            // vars and objects used later
            String lineSeperator = System.getProperty("line.separator");
            StringBuilder sb = new StringBuilder();
            Main main = new Main();

            //session.connect();
            session.connect(30000);   // making a connection with timeout.
            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            InputStream in = channel.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            // start telnet session
            channel.setCommand("telnet 192.168.222.128 -l sshuser");
            out = channel.getOutputStream();
            channel.connect();
            // wait a little bit for telnet to be ready to take the input
            Thread.sleep(500);
            // pass the password
            out.write(("password\n").getBytes());
            out.write(("\n").getBytes());
            Thread.sleep(500);
            // flush reader, very important!
            out.flush();

            // Read from Bufferreader until the current line contains a specific string
            // For my real application it would be "---       END", for this example i
            // used something from the last line my machine returns. Very important that this string
            // appears on every possible output, or you will stuck in a while loop!
            //
            // Tried it with while((reader.readline())!=null) but this ends in a infinity loop too.
            // Since in my application there is an String that always get returned i didn't look it further up
            String responeFromLogin = main.readOutput("security updates.", reader, lineSeperator, sb);

            // Working with the response, in this example a simple fail-->Exception, success --> progress
            if (responeFromLogin.contains("Login incorrect")) {
                throw new Exception("Failed: Login");
            }
            System.out.println("Login Successfull");

            // Log in was successful, so lets do the next command, basiclly the same routine again
            out.write(("dir\n").getBytes());
            Thread.sleep(500);
            out.flush();
            // Again, not bulletproofed in this example
            String responseFromHelp = main.readOutput("examples.desktop", reader, lineSeperator, sb);
            if (!responseFromHelp.contains("test")) {
                throw new Exception("Failed: Help");
            }
            System.out.println("Folder Found");



        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSchException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("_________________________");
            System.out.println("I am done");
            if (session != null) {
                session.disconnect();
            }
        }
    }

    public String readOutput(String endString, BufferedReader reader, String lineSeperator, StringBuilder sb) {
        String line;
        String returnString = "Error";

        while (true) {
            try {
                line = reader.readLine();
                if (line.contains(endString)) {
                    sb.append(line).append(lineSeperator);
                    returnString = sb.toString();
                    break;
                } else {
                    sb.append(line).append(lineSeperator);
                }
            } catch (IOException e) {
                returnString = "Error";
                e.printStackTrace();
            }
        }
        return returnString;
    }
}