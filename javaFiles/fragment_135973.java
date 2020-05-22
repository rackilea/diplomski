public static String formatFine(Address obj) {
    return new StringBuilder("<div class=\"address-wrapper\">\n\t<div class=\"addr-line\">")
        .append(obj.getLine1())
        .append("</div>\n\t<div class=\"addr-line\">")
        .append(obj.getLine2())
        .append("</div>\n\t<div class=\"addr-city\">")
        .append(obj.getCity())
        .append("</div>\n\t<div class=\"addr-state\">")
        .append(obj.getState())
        .append("</div>\n\t<div class=\"addr-country\">")
        .append(obj.getCountry())
        .append("</div>\n\t<div class=\"addr-zip\">")
        .append(obj.getZip())
        .append("</div>\n</div>\n").toString();
}