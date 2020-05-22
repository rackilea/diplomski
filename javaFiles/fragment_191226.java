import java.io.ByteArrayInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import javax.xml.bind.DatatypeConverter;

import org.joda.time.DateTime;

public class SerialTest {
    public static void main(final String... args) throws Exception {
        final String s = "aced0005737200166f72672e6a6f64612e74696d652e4461746554696d65b83c78646a5bddf90200007872001f6f72672e6a6f64612e74696d652e626173652e426173654461746554696d65fffff9e14f5d2ea30200024a0007694d696c6c69734c000b694368726f6e6f6c6f677974001a4c6f72672f6a6f64612f74696d652f4368726f6e6f6c6f67793b787000000168cd2d829e737200276f72672e6a6f64612e74696d652e6368726f6e6f2e49534f4368726f6e6f6c6f67792453747562a9c811667137502703000078707372001f6f72672e6a6f64612e74696d652e4461746554696d655a6f6e652453747562a62f019a7c321ae30300007870770500035554437878";
        final byte[] bytes = DatatypeConverter.parseHexBinary(s);
        // you would probably use bytes = resultSet.getBytes("acquire_Date") to get the byte array

        final ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        final ObjectInput in = new ObjectInputStream(bis);
        final DateTime dt = (DateTime) in.readObject();

        System.out.println(dt);
    }
}