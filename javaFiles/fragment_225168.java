public static void main(String[] args) throws DocumentException {
    String xmlText = getContents(new File("/home/bpgergo/Temp/9682103.xml"));
    Document doc = DocumentHelper.parseText(xmlText);
    String session = doc.valueOf("SOAP-ENV:Envelope/SOAP-ENV:Body//m0:Avail");
    System.out.println("session:"+session);
}