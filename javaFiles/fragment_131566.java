import java.io.*;
import java.math.*;
import java.security.*;
import java.security.spec.*;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.*;
import org.w3c.dom.*;

String s = "<RSAKeyValue><Modulus>iDedXXkixunqnh278qUll8sWYIqyy/FfTd59kq6HDwXDapOXmYKkcsy+HTFbbLRb/bbJsMVEessdbwEVysedzx38QnWOBmGmY1VTKO8Ph3X1dkVktMT8zCbgKMBBT17dTbBE+B9zO6jqcN120qaHc8rOGC2KztM5xnEa3hNvSwk="
        +"</Modulus><Exponent>AQAB"
        +"</Exponent><P>1TmBWEl5DARzhcmaaLJELymx0Sw3xcdEqEi/2nnIYrLE1YCb0OQVHvyFBBnXEgk81zxoqkPmItNO1yHzX7UIzw=="
        +"</P><Q>o4tFYK9HE4UhaLUGzx9WpFlX8NXsXcYxzV2ewCR1EXaMCA8xowSyyDfzhUugfKI02rTeQRucTnuttbJEQsu0pw=="
        +"</Q><DP>IKzGSHxB43iPJ3JkiiS/VCbki/Rlu5Y0zEERvW4qKg3RIhKqThGVtwDldWJsVeQ6gZVNSMJM8wtEqq0WOZVpew=="
        +"</DP><DQ>UAn3GExwEqOTKDWAcZm6w5BeM6Xemj5HXWS2Lv8otDU6by9QcaH5BXgsnE3Y62ZPS8I9C8xBgT+SUlw+gBpF/Q=="
        +"</DQ><InverseQ>lbcDsYsWBNg365eRqp8n8sGLR5gdG+SV5YUAZY+Bf1P2V9cpIm8YpVcUKZXkE5SwGub7p+mCQkAbaoT/pQyXOg=="
        +"</InverseQ><D>fi82wa5DfwyV4J8eymod5v2k3w3dD3urk5D1tnmid1IZcpMCrpwNBqOPwa9FR+/T/7XiJLS4+R9LRtc0fsJn9maEfUV26ry3vqQXYRlobdsWMFuNZPmHD1S7ef1fkGthDGWMmdiKyyy5Cy+lXEM/9VlexSKMxZc3Tor+v5SCB/k="
        +"</D></RSAKeyValue>";

DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
// there are many options possible for XML but not needed here
Element el = db.parse(new ByteArrayInputStream (s.getBytes())).getDocumentElement();
// or other source including file if applicable
String[] names = {"Modulus", "Exponent", "D", "P", "Q", "DP", "DQ", "InverseQ"};
BigInteger[] vals = new BigInteger [names.length];
for( int i = 0; i < names.length; i++ ){ 
    String v = el.getElementsByTagName(names[i]).item(0).getTextContent();
    vals[i] = new BigInteger(1, DatatypeConverter.parseBase64Binary(v));
}
PrivateKey pk = KeyFactory.getInstance("RSA").generatePrivate(
        new RSAPrivateCrtKeySpec (vals[0], vals[1], vals[2], vals[3], vals[4], vals[5], vals[6], vals[7]) );
//
Signature si = Signature.getInstance("SHA1withRSA");
si.initSign(pk); si.update("foobar\r\n".getBytes()); byte[] ss = si.sign();