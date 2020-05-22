public class SOAPInputGenerator {

public static void main(String[] args) throws Exception {
    WsdlProject project = new WsdlProject();
    WsdlInterface[] wsdls = WsdlImporter.importWsdl(project, "http://localhost:7000/Solicitud?wsdl");
    WsdlInterface wsdl = wsdls[0];
    for (Operation operation : wsdl.getOperationList()) {
        WsdlOperation wsdlOperation = (WsdlOperation) operation;
        System.out.println("OP:"+wsdlOperation.getName());
        System.out.println("Request:");
        System.out.println(wsdlOperation.createRequest(true));
        System.out.println("Response:");
        System.out.println(wsdlOperation.createResponse(true));
    }
}
}