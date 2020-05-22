153        // this hidden field will be checked in the decode method to
154        // determine if this form has been submitted.         
155        writer.startElement("input", component);
156        writer.writeAttribute("type", "hidden", "type");
157        writer.writeAttribute("name", clientId,
158                              "clientId");
159        writer.writeAttribute("value", clientId, "value");
160        writer.endElement("input");
161        writer.write('\n');