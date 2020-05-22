import java.util.Iterator;
import org.xbill.DNS.ARecord;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.TXTRecord;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

public class DNS {

    public static void main(String[] args) {
        try {
            Lookup lookup = new Lookup("google.com", Type.ANY);
            Record[] records = lookup.run();

            if (lookup.getResult() == Lookup.SUCCESSFUL) {
                String responseMessage = null;
                String listingType = null;
                for (int i = 0; i < records.length; i++) {
                    if (records[i] instanceof TXTRecord) {
                        TXTRecord txt = (TXTRecord) records[i];
                        for (Iterator j = txt.getStrings().iterator(); j
                                .hasNext();) {
                            responseMessage += (String) j.next();
                        }
                        System.out.println("TXRecord " + responseMessage);
                    } else if (records[i] instanceof ARecord) {
                        listingType = ((ARecord) records[i]).getAddress()
                                .getHostAddress();
                        System.out.println("ARecord address : " + listingType);
                    }
                }
            }
        } catch (TextParseException e) {
            e.printStackTrace();
        }
    }
}