public static String formatRich(Address obj) {
    return "<div class=\"address-wrapper\">\n\t<div class=\"addr-line\">"
        + obj.getLine1()
        + "</div>\n\t<div class=\"addr-line\">"
        + obj.getLine2()
        + "</div>\n\t<div class=\"addr-city\">"
        + obj.getCity()
        + "</div>\n\t<div class=\"addr-state\">"
        + obj.getState()
        + "</div>\n\t<div class=\"addr-country\">"
        + obj.getCountry()
        + "</div>\n\t<div class=\"addr-zip\">"
        + obj.getZip()
        + "</div>\n</div>\n";
}