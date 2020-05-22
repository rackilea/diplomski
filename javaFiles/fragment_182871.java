package connection;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GTEVDatabaseConnection {

private final Channel channel;
private static final int SSH_PORT = 22;
private static final String DATABASE = "databasename",
        DATABASE_USER = "databaseuser",
        DATABASE_PASSWORD = "databasepasswd",
        DATABASE_HOST = "databasehost",
        SSH_HOST = "sshhost";

public GTEVDatabaseConnection(String sshUsername, String sshPassword) {
    try {
        Session sshSession = createSshSession(sshUsername, sshPassword);
        this.channel = sshSession.openChannel("exec");
        ((ChannelExec) channel).setErrStream(System.err);
    } catch (JSchException ex) {
        Logger.getLogger(GTEVDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        throw new SQLException("username or password didn´t work");
    }
}

/**
 * F&uuml;hrt eine SQL-Abfrage aus und liefert eine Tabelle der Ergebnisse
 * @param query Der SQL-Code
 * @return Tabelle der Ergebnisse. Erste Dimension = Zeile; zweite Dimension = Spalte
 * @throws SQLException Tritt auf, wenn der SQL-Befehl eine Fehler ausl&ouml;ste. (Fehler wird per System.err.println(...) ausgegeben)
 */
public ArrayList<ArrayList<String>> execQuery(String query) throws SQLException {
    ArrayList<ArrayList<String>> formattedResult = null;
    try {
        ((ChannelExec) channel).setCommand("mysql -u" + DATABASE_USER + " -p" + DATABASE_PASSWORD + " -h" + DATABASE_HOST + " -e'" + query + "' " + DATABASE);
        InputStream in = channel.getInputStream();
        channel.connect();
        //TODO check whether sqlcode is correct

        String result = readResult(in);
        if(result == null){
            throw new SQLException("Invalid SQL-Code");
        }
        formattedResult = new ArrayList<>();
        for(String row: result.split("\n")){
            ArrayList<String> fields = new ArrayList<>();
            fields.addAll(Arrays.asList(row.split("\t")));
            formattedResult.add(fields);
        }

        channel.disconnect();
    } catch (JSchException | IOException ex) {
        Logger.getLogger(GTEVDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
    }

    return formattedResult;
}

private String readResult(InputStream in) throws IOException {
    if (in.available() <= 0) {
        return null;
    }

    StringBuilder output = new StringBuilder();
    int nextByte;
    do {
        nextByte = in.read();
        output.append((char) nextByte);
    } while (nextByte != -1);

    return output.toString();
}

private Session createSshSession(String sshUsername, String sshPassword) throws JSchException {
    Session session = new JSch().getSession(sshUsername, SSH_HOST, SSH_PORT);
    session.setPassword(sshPassword);
    session.setConfig("StrictHostKeyChecking", "no");
    session.connect();
    return session;
}
}