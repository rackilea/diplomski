public static HtmlFileInput insertFileInputWithValue(String name, String value, 
    String contentType, HtmlPage page, DomElement parent) {
  // Necessary, otherwise HtmlUnit doesn't generate HtmlFileInput, but HtmlTextInput by default
  AttributesImpl ai = new AttributesImpl();
  ai.addAttribute(null, null, "type", null, "file");
  ai.addAttribute(null, null, "name", null, name);

  HtmlFileInput input = (HtmlFileInput) HTMLParser.getFactory("input")
    .createElementNS(page, null, "input", ai, true);
  input.setValueAttribute(value);
  input.setContentType(contentType);
  parent.appendChild(input);

  return input;
}