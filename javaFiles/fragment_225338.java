public static void main(String[] args) {
    try {
        String uri = "http://test.com/IntegratedServices/IntegratedServices.asmx?op=GetUserInfo";

        String postData = new XmlTest().xmlRequest("QWERTY10");

        URL url = new URL(uri);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true); // This is important. If you not set doOutput it is default value is false and throws java.net.ProtocolException: cannot write to a URLConnection exception 
        connection.setRequestMethod("POST"); // This is method type. If you are using GET method you can pass by url. If method post you must write
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8"); // it is important if you post utf-8 characters

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream()); // This three lines is importy for POST method. I wrote preceding comment.
        wr.write(postData.getBytes());
        wr.close();

        InputStream xml = connection.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(xml));
        String line = "";
        String xmlResponse = "";
        while ((line = reader.readLine()) != null) {
            xmlResponse += line;
        }

        File file = new File("D://test.xml"); // If you want to write as file to local.
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(xmlResponse);
        fileWriter.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public String xmlRequest(String pin) {
    return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
            + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
            + "  <soap:Body>\n"
            + "    <GetUserInfo xmlns=\"http://tempuri.org/\">\n"
            + "      <pin>" + pin + "</pin>\n"
            + "    </GetUserInfo>\n"
            + "  </soap:Body>\n"
            + "</soap:Envelope>";
}