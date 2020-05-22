import org.bouncycastle.util.encoders.Base64;

// create handshake object with some sample data
ASN1Handshake1 handshake = new ASN1Handshake1("a", "b", "ID_K", "ID_PASS");

// convert it to base64
String base64String = new String(Base64.encode(handshake.getEncoded()));
System.out.println(base64String);