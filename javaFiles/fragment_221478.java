package hello;

import javax.xml.ws.Endpoint;

public class Publisher {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Endpoint.publish("http://LH.com:9292/ws/milli", new HelloWorld());
    }

}