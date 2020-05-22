final String html = "<tr valign=\"top\">\n"
        + "    <td></td>\n"
        + "    <td><a href=\"#\"> 1 </a></td>\n"
        + "    <td><a href=\"#\"> 2 </a></td>\n"
        + "    <td><span> 3 </span></td>\n"
        + "    <td><a href=\"#\"> 4 </a></td>\n"
        + "    <td><a href=\"#\"> 5 </a></td>\n"
        + "    <td><a href=\"#\"> 6 </a></td>\n"
        + "</tr>";

Document doc = Jsoup.parse(html);

Element nextToSpan = doc.select("span").first().nextElementSibling();