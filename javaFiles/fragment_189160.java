package jiraAlerting;

import javax.net.ssl.TrustManager;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;


public class restLab {

    WebResource webResource;
    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
        new javax.net.ssl.HostnameVerifier(){

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("your host here")) {
                    return true;
                }
                return false;
            }
        });
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        restLab rl = new restLab();

        //rl.connectToJiraViaRest();

        rl.editJiraTicket();
    }

    public void connectToJiraViaRest(){
        //System.setProperty("javax.net.ssl.trustStore", "C:/SSL/clientkeystore.jks");

        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("username","password"));

        webResource = client.resource("https://host/jira/rest/api/2/issue/issueID");

    }

    public void editJiraTicket(){
        connectToJiraViaRest();

        ClientResponse response = webResource.type("application/json").put(ClientResponse.class,"{\"fields\":{\"customfield_11420\":{\"value\" :\"No\"}}}");
        //"{\"fields\":{\"customfield_11420\":\"Yes\"}}"
        response.close();
    }
}