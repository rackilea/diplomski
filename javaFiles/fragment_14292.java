class Element1 {
 ...
 int i = 0;
 ...
public void process(String s) throws SAXException {

    try {

        String[] elements = s.split("\\|");
        atts.clear();
        i++;

        atts.addAttribute("", "", "Id", "", "" + i);

        th.startElement("", "", "el", atts);
        th.startElement("", "", "text", atts);
        th.characters(elements[0].toCharArray(), 0, elements[0].length());
        th.endElement("", "", "text");
        th.endElement("", "", "el");

    }

    catch (Exception e) {
        System.out.print("Out of bounds! DOH! should have used vectors");
    }
}}