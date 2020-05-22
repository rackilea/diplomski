public String conecta(String xmlNfedados, URL url) throws SOAPException{
    String outputString = "";
    try {
        if(context != null){

            URLConnection connection = url.openConnection();
            HttpsURLConnection httpsconn = (HttpsURLConnection) connection;

            httpsconn.setSSLSocketFactory(this.context.getSocketFactory());

            byte[] buffer = new byte[xmlNfedados.length()];
            buffer = xmlNfedados.getBytes();

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            bout.write(buffer);

            byte[] b = bout.toByteArray();

            httpsconn.setRequestProperty("Content-Type", "application/soap+xml");
            httpsconn.setRequestMethod("POST");

            httpsconn.setDoOutput(true);
            httpsconn.setDoInput(true);

            OutputStream out = httpsconn.getOutputStream();

            out.write(b);
            out.close();

            InputStreamReader isr = new InputStreamReader(httpsconn.getInputStream());

            BufferedReader in = new BufferedReader(isr);

            String responseString = "";

            while((responseString = in.readLine()) != null){
                outputString = outputString + responseString;
            }

            /*MimeHeaders header = new MimeHeaders();
            header.addHeader("Content-Type", "application/soap+xml");

            MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);

            SOAPMessage message;
            message = factory.createMessage(header, new ByteArrayInputStream(xmlNfedados.getBytes()));
            SOAPConnection con = SOAPConnectionFactory.newInstance().createConnection();
            res = con.call(message, url);*/

        } else {
            throw new IllegalStateException("SSContext não inicializado");
        }

        //con.close();
    } catch (IOException e) {
        e.printStackTrace();
    } 
    return outputString;
}