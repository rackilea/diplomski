// HTTP POST Upload
public void doUpload(File uploadFile, Map<String, String> values, String nombreArchivo, String[] nombreAtributos) throws Exception{

            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(uploadFile,values,nombreArchivo,nombreAtributos), urlWS);

            soapConnection.close(); 
}