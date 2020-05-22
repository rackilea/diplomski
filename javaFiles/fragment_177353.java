import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoType;
import com.solab.iso8583.parse.ConfigParser;
import com.solab.iso8583.impl.SimpleTraceGenerator;
import java.io.File;
import java.io.IOException;

class Sample {
    public static void main(String[] args) {
        // Check http://j8583.sourceforge.net/javadoc/index.html

        MessageFactory<IsoMessage> mf = new MessageFactory<IsoMessage>();

        try {
            String path="j8583.xml";
            ConfigParser.configureFromUrl(mf, new File(path).toURI().toURL());
        } catch (IOException e) {
            e.printStackTrace();
        }

        mf.setForceSecondaryBitmap(true);
        mf.setUseBinaryBitmap(true);
        mf.setAssignDate(true); // This sets field 7 automatically
        mf.setTraceNumberGenerator(new SimpleTraceGenerator((int)  (System.currentTimeMillis() % 100000)));

        IsoMessage m = mf.newMessage(0x200); // You must use 0x200, 0x400, etc.
        m.setValue(3, "000000", IsoType.ALPHA, 6);
        m.setValue(11, "000001", IsoType.ALPHA, 6);
        m.setValue(41, "3239313130303031", IsoType.ALPHA, 16);
        m.setValue(60, "001054455354204D45535347", IsoType.ALPHA, 24);
        m.setValue(70, "0301", IsoType.ALPHA, 4);
        m.setForceSecondaryBitmap(true);

        System.out.println(m.debugString());
    }
}