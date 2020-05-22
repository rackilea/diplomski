--- /tmp/a  2011-09-19 14:57:49.582065002 -0400
+++ /tmp/b  2011-09-19 15:00:06.942065007 -0400
@@ -1,7 +1,7 @@
 @WebService(serviceName = "MyHandler", wsdlLocation = "WEB-INF/wsdl/MyHandler.wsdl")
 public class MyHandler {
    @WebMethod(operationName = "putHL7Data")
-   public String putHL7Data(@WebParam(name = "putXML") String xml) {
+   public String putHL7Data(@WebParam(name = "putXML", targetNamespace="http://MyProject.MyPackage/") String xml) {
       // Handle message
    }
 }