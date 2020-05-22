public class XMPPReceiverServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res)
          throws IOException {
    XMPPService xmpp = XMPPServiceFactory.getXMPPService();
    Message message = xmpp.parseMessage(req);    
    JID fromJid = message.getFromJid();
    String body = message.getBody();
    //Save to Big Table
  }
}