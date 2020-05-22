import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


try{
                URL url = new URL(basicPayPalPath+"/v1/oauth2/token");
                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setRequestMethod("POST");
                uc.setDoOutput(true);
                String userpass = clientID + ":" + clientSecret;
                String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

                uc.setRequestProperty("Accept", "application/json");
                uc.setRequestProperty("Authorization", basicAuth);
                uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                DataOutputStream wr = new DataOutputStream (uc.getOutputStream ());
                wr.writeBytes ("grant_type=client_credentials");
                wr.flush ();
                wr.close ();

                InputStream is = uc.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer response = new StringBuffer(); 
                while((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                JSONParser jsonParser = new JSONParser();
                System.out.println(response.toString());
                JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
                Set<Map.Entry<String, String>> map = jsonObject.entrySet();
                for(Map.Entry<String, String> entry : map){
                    System.out.println(entry.toString());
                }
            }catch (IOException | ParseException e){
                e.printStackTrace();
            }