InputSource source = new InputSource(new StringReader(responseEntity.getBody()));
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
final Document document = db.parse(source);

final String resultCode = xPath.compile(
        "//*[local-name()='Envelope']/*[local-name()='Body']/*[local-name()='ResultCode']/text()")
        .evaluate(document);