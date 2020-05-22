import java.io.InputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Stock.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        URL url = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.historicaldata%20where%20symbol%20in%20(%22MSFT%22)%20and%20startDate%3D%222011-2-12%22%20and%20endDate%3D%222011-2-15%22%0A%09%09&diagnostics=true&env=http%3A%2F%2Fdatatables.org%2Falltables.env");
        InputStream xmlStream = url.openStream();
        Stock stock = (Stock) unmarshaller.unmarshal(xmlStream);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(stock, System.out);
    }

}