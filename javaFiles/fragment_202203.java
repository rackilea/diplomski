public String prettyPrintHTML(String rawHTML)
{    
    Tidy tidy = new Tidy();
    tidy.setXHTML(true);
    tidy.setIndentContent(true);
    tidy.setPrintBodyOnly(true);
    tidy.setTidyMark(false);

    // HTML to DOM
    Document htmlDOM = tidy.parseDOM(new ByteArrayInputStream(rawHTML.getBytes()), null);

    // Pretty Print
    OutputStream out = new ByteArrayOutputStream();
    tidy.pprint(htmlDOM, out);

    return out.toString();
}