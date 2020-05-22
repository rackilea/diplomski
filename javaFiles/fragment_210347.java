package solverapplet;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

/**
 *
 * @author you
 */
public class Solverapplet {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        Socket s = null;
        try {
            // make connection
            s = new Socket("localhost", 4445);

            // define streams
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            // write data
            out.write("gamma");
            out.newLine();
            out.flush();

            // read response
            String returnData = in.readLine();
            System.out.println(returnData);

        } catch (UnknownHostException ex) {
            Logger.getLogger(Solverapplet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Solverapplet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            s.close();
        }
    }
}