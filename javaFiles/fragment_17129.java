public class MySelectBooleanButtonRenderer extends SelectBooleanButtonRenderer {

    @Override
    protected void encodeMarkup(FacesContext context, SelectBooleanButton button) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = button.getClientId(context);
        boolean checked = Boolean.valueOf(ComponentUtils.getValueToRender(context, button));
        boolean disabled = button.isDisabled();
        String inputId = clientId + "_input";
        String label = checked ? button.getOnLabel() : button.getOffLabel();
        String icon = checked ? button.getOnIcon() : button.getOffIcon();

        //button
        writer.startElement("div", null);
        writer.writeAttribute("id", clientId, "id");
        writer.writeAttribute("type", "button", null);
        writer.writeAttribute("class", button.resolveStyleClass(checked, disabled), null);
        if(disabled) writer.writeAttribute("disabled", "disabled", null);
        if(button.getTitle()!= null) writer.writeAttribute("title", button.getTitle(), null);
        if(button.getStyle() != null) writer.writeAttribute("style", button.getStyle(), "style");

        //input
        writer.startElement("div", null); // <-- Added.
        writer.writeAttribute("class", "ui-helper-hidden-accessible", null); // <-- Added.
        writer.startElement("input", null);
        writer.writeAttribute("id", inputId, "id");
        writer.writeAttribute("name", inputId, null);
        writer.writeAttribute("type", "checkbox", null);
        // writer.writeAttribute("class", "ui-helper-hidden", null); <-- Removed.

        if(checked) writer.writeAttribute("checked", "checked", null);
        if(disabled) writer.writeAttribute("disabled", "disabled", null);
        if(button.getOnchange() != null) writer.writeAttribute("onchange", button.getOnchange(), null);

        writer.endElement("input");
        writer.endElement("div"); // <-- Added.

        //icon
        if(icon != null) {
            writer.startElement("span", null);
            writer.writeAttribute("class", HTML.BUTTON_LEFT_ICON_CLASS + " " + icon, null);
            writer.endElement("span");
        }

        //label
        writer.startElement("span", null);
        writer.writeAttribute("class", HTML.BUTTON_TEXT_CLASS, null);
        writer.writeText(label, "value");
        writer.endElement("span");

        writer.endElement("div");
    }

}