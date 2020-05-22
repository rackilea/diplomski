@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) {
    // ...
    String xmlDoc = getXML();
    byte[] content = xmlDoc.getBytes("UTF-8");

    response.setContentType("text/xml");
    response.setCharacterEncoding("UTF-8");
    response.setContentLengthLong(content.length);
    response.getOutputStream().write(content);
}