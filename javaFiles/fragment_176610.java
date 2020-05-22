import javax.xml.rpc.Call;
    import javax.xml.rpc.Service;
    import javax.xml.rpc.JAXRPCException;
    import javax.xml.namespace.QName;
    import javax.xml.rpc.ServiceFactory;
    import javax.xml.rpc.ParameterMode;

    public class DIIHello {

        private static String qnameService = "MyHelloService";
        private static String qnamePort = "MyHelloServiceRPC";
        private static String endpoint =
            "http://localhost:80/MyHelloService/MyHelloService";

        private static String BODY_NAMESPACE_VALUE =
            "urn:MyHelloService/wsdl";
        private static String ENCODING_STYLE_PROPERTY =
            "javax.xml.rpc.encodingstyle.namespace.uri";
        private static String NS_XSD =
            "http://www.w3.org/2001/XMLSchema";
        private static String URI_ENCODING =
            "http://schemas.xmlsoap.org/soap/encoding/";

        public static void main(String[] args) {
            try {

                ServiceFactory factory =
                    ServiceFactory.newInstance();
                Service service =
                    factory.createService(new QName(qnameService));

                QName port = new QName(qnamePort);

                Call call = service.createCall(port);
                call.setTargetEndpointAddress(endpoint);

                call.setProperty(Call.SOAPACTION_USE_PROPERTY,
                    new Boolean(true));
                call.setProperty(Call.SOAPACTION_URI_PROPERTY, "");
                call.setProperty(ENCODING_STYLE_PROPERTY,
                    URI_ENCODING);
                QName QNAME_TYPE_STRING = new QName(NS_XSD, "string");
                call.setReturnType(QNAME_TYPE_STRING);


                call.setOperationName(new QName(BODY_NAMESPACE_VALUE,
                    "sayHello"));
                 //For passing parameter
                call.addParameter("String_1", QNAME_TYPE_STRING,
                    ParameterMode.IN);
                String[] params = { "Kuntal" };

                String result = (String)call.invoke(params);
                System.out.println(result);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }