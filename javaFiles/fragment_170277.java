package com.company;

import java.io.DataInputStream;
import java.io.File;
//import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class TestAuth {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        File file = new File("test.json");
        try {
            JSONParser parser = new JSONParser();
            //Use JSONObject for simple JSON and JSONArray for array of JSON.
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader(file.getAbsolutePath()));//path to the JSON file.
            System.out.println(data.toJSONString());

            String paramValue = "param\\with\\backslash";
            String yourURLStr = "http://host.com?param=" + java.net.URLEncoder.encode(paramValue, "UTF-8");

            URL url2 = new URL("https://0c193bc3-8439-46a2-a64b-4ce39f60b382.mock.pstmn.io");
            HttpsURLConnection conn = (HttpsURLConnection) url2.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer aanjd-usnss092-mnshss-928nss");

            conn.setDoOutput(true);
            OutputStream outStream = conn.getOutputStream();
            OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
            outStreamWriter.write(data.toJSONString());
            outStreamWriter.flush();
            outStreamWriter.close();
            outStream.close();
            String response = null;

            System.out.println(conn.getResponseCode());
            System.out.println(conn.getResponseMessage());

            DataInputStream input = null;
            input = new DataInputStream (conn.getInputStream());
            while (null != ((response = input.readLine()))) {
                System.out.println(response);
                input.close ();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}