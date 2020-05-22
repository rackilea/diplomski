File attachmentFile = new File("soap_sample.xml");
    FileInputStream fis = new FileInputStream(attachmentFile);
    InputStreamReader isr = new InputStreamReader(fis, "UTF8");
    BufferedReader in = new BufferedReader(isr);

    StringBuffer buffer = new StringBuffer();

    String inputLine = null;
    while ((inputLine = in.readLine()) != null) {
        buffer.append(inputLine);
    }

    InputStream is = IOUtils.toInputStream(buffer.toString(), "UTF-8");

    SOAPMessage soapMessage = MessageFactory.newInstance().createMessage(new MimeHeaders(), is);