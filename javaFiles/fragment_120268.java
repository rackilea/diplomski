package custom;    /*imports omitted*/

public class CustomErrorRenderer extends Renderer {

  @Override @SuppressWarnings("unchecked")
  public void encodeEnd(FacesContext context,
      UIComponent component) throws IOException {
    ResponseWriter writer = context.getResponseWriter();
    writer.startElement("div", component);
    writer.writeAttribute("id", component.getClientId(context), "id");
    writer.writeAttribute("style", "color: red", null);
    writer.startElement("ul", null);
    Iterator<String> clientIds = context.getClientIdsWithMessages();
    while (clientIds.hasNext()) {
      String clientId = clientIds.next();
      Iterator<FacesMessage> messages = context.getMessages(clientId);
      if (!messages.hasNext()) { continue; }
      String javaScript = "var field = document.getElementById('"
          + clientId + "');" + "if(field == null) return false;"
          + "field.focus(); return false;";
      writer.startElement("li", null);
      writer.startElement("a", null);
      writer.writeAttribute("onclick", javaScript, null);
      writer.writeAttribute("href", "#", null);
      while (messages.hasNext()) {
        writer.writeText(messages.next().getSummary(), null);
      }
      writer.endElement("a");
      writer.endElement("li");
    }
    writer.endElement("ul");
    writer.endElement("div");
  }
}