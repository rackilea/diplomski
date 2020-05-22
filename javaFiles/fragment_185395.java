private static final Pattern P = Pattern.compile("<a\\s.*?href=([^ >]+).*?<img\\s.*?src=([^ ]+)(.*?>.*?<\\/a>)");
private static final String TEXT = "<font size=\"4\">Mail              : </font><a href=\"mailto:c.bantz@pgt-gmbh.com\"><u><font size=\"4\" color=\"#0000ff\">s.weber@pgt-gmbh.com</font></u></a><br />"
    + "<br />"
    + "<font size=\"4\">Internet        : </font><a href=\"http://www.pgt-gmbh.com/\"><u><font size=\"4\" color=\"#0000ff\">http://www.pgt-gmbh.com</font></u></a><font size=\"4\"> </font><br />"
    + "<br />"
    + "<br />"
    + "<font size=\"4\"> </font><a class=\"domino-attachment-link\" style=\"display: inline-block; text-align: center\" href=\"/_dv/_dv/documents_DE.nsf/0/7fadd8be280a2e34c1257dfd00307098/$FILE/Anfrage.pdf\" title=\"Anfrage.pdf\"><img src=\"/_dv/_dv/documents_DE.nsf/0/7fadd8be280a2e34c1257dfd00307098/f_Text/0.5F66?OpenElement&FieldElemFormat=gif\" width=\"32\" height=\"32\" alt=\"Anfrage.pdf\" border=\"0\" /> - Anfrage.pdf</a>";
private static final String NEWLINE_TEXT = "<font size=\"4\">Mail              : </font><a href=\"mailto:c.bantz@pgt-gmbh.com\"><u><font size=\"4\" color=\"#0000ff\">s.weber@pgt-gmbh.com</font></u></a><br />\n"
    + "<br />\n"
    + "<font size=\"4\">Internet        : </font><a href=\"http://www.pgt-gmbh.com/\"><u><font size=\"4\" color=\"#0000ff\">http://www.pgt-gmbh.com</font></u></a><font size=\"4\"> </font><br />\n"
    + "<br />\n"
    + "<br />\n"
    + "<font size=\"4\"> </font><a class=\"domino-attachment-link\" style=\"display: inline-block; text-align: center\" href=\"/_dv/_dv/documents_DE.nsf/0/7fadd8be280a2e34c1257dfd00307098/$FILE/Anfrage.pdf\" title=\"Anfrage.pdf\"><img src=\"/_dv/_dv/documents_DE.nsf/0/7fadd8be280a2e34c1257dfd00307098/f_Text/0.5F66?OpenElement&FieldElemFormat=gif\" width=\"32\" height=\"32\" alt=\"Anfrage.pdf\" border=\"0\" /> - Anfrage.pdf</a>";

public static void main(String[] args) {
    Matcher m = P.matcher(TEXT);
    if (m.find()) {
        System.out.println(m.group());
    }
    m = P.matcher(NEWLINE_TEXT);
    if (m.find()) {
        System.out.println(m.group());
    }
}