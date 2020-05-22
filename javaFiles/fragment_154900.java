import it.milano.comune.GetOpenWifiResponse.GetOpenWifiResult;
import it.milano.comune.WSOpenData;

import java.net.URL;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        WSOpenData ws = new WSOpenData(new URL("http://ws.dati.comune.milano.it/opendata/wsopendata.asmx?WSDL"));

        GetOpenWifiResult rw = ws.getWSOpenDataSoap().getOpenWifi(" ");
        for (Object o : rw.getContent()) {
            System.out.println(o.getClass().getName());
            Element e = (Element) o;
            NodeList c = e.getChildNodes();

            System.out.println(c);
            for (int i = 0; i < c.getLength(); i++) {
                Node table = c.item(i);

                System.out.println("tab");

                for (int i2 = 0; i2 < table.getChildNodes().getLength(); i2++) {
                    Node property = table.getChildNodes().item(i2);
                    System.out.println("\tp: " + property);
                }

            }

        }

        long x = 1;
    }

}