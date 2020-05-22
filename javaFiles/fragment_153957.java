import java.io.*;
import org.xml.sax.*;
import org.junit.*;
import org.apache.commons.digester.*;

import static org.junit.Assert.*;

public class DigesterTest {
    @Test
    public void testItemBillingDetailsNotNull() throws IOException, SAXException {
        Digester d = new Digester();
        MyApp.digestItemsDetails(d, "item");
        Item item = (Item) d.parse(DigesterTest.class.getResource("/test.xml"));
        assertNotNull(item.getBillingDetails());
        assertEquals("NONE", item.getBillingDetails().getBillFrequency());
        assertEquals("NOT_DEFINED", item.getBillingDetails().getBillingCycle());
    }
}