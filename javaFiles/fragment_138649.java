package dk.fmcgsolutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import lotus.domino.AgentContext;

public class XAgent {

    public static void run(AgentContext agentContext, String xpageName) {

        try {

            String dbPath = agentContext.getCurrentDatabase().getFilePath();
            String url = "http://localhost/" + dbPath + "/" + xpageName + ".xsp";

            System.out.println("Starting " + xpageName + " in database " + dbPath);

            URL xPageURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) xPageURL.openConnection();

            conn.connect();

            switch (conn.getResponseCode()) {
            case HttpURLConnection.HTTP_OK:
                // read from the urlconnection via the bufferedreader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println("Response: " + line);
                }
                bufferedReader.close();

                break;
            case HttpURLConnection.HTTP_INTERNAL_ERROR:
                System.out.println("Interal server error while running");
                break;
            default:
                System.out.println("An error occurred: " + conn.getResponseCode());
                System.out.println("Error message: " + conn.getResponseMessage());
                break;
            }

            conn.disconnect();

            System.out.println("Finished " + xpageName + " in database " + dbPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}