public class Test{

    public static void main(String[] args) {
        String sentence = "<definitions xmlns:tns=\"http://local.host/web/test/11/soap/testserver.php\" xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\" xmlns=\"http://schemas.xmlsoap.org/wsdl/\" name=\"DatixInterface\" targetNamespace=\"http://local.host/web/test/11/soap/testserver.php\">";

        String str = sentence.replaceAll("http://local.host/web/test/11", "http://web.server/");
        System.out.println(str);
    }
}