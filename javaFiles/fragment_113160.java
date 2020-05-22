public class Test {
    public static void main(String[] args) {
        String response="<table class=\"prk-fields\">\n" +
                "    <tbody>\n" +
                "        <tr class=\"field_1 visibility-public field_type_textbox\">\n" +
                "            <td class=\"label\">Date</td>\n" +
                "            <td class=\"data\">\n" +
                "                <p>\"2144\"</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr class=\"field_3 visibility-public alt field_type_textbox\">\n" +
                "            <td class=\"label\">Location</td>\n" +
                "            <td class=\"data\">\n" +
                "                <p>Planet Earth</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr class=\"field_4 visibility-public field_type_url\">\n" +
                "            <td class=\"label\">By</td>\n" +
                "            <td class=\"data\">\n" +
                "                <p><a href=\"https://en.wikipedia.org/wiki/Extraterrestrial_life\">Extraterrestrials</a>\n" +
                "                </p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr class=\"field_5 visibility-public alt field_type_url\">\n" +
                "            <td class=\"label\">Victims</td>\n" +
                "            <td class=\"data\">\n" +
                "                <p>0</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr class=\"field_6  visibility-public field_type_textbox\">\n" +
                "            <td class=\"label\">Reaction</td>\n" +
                "            <td class=\"data\">\n" +
                "                <p>Apathetic</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr class=\"field_7 visibility-public alt field_type_textarea\">\n" +
                "            <td class=\"label\">About</td>\n" +
                "            <td class=\"data\">\n" +
                "                <p>it's about the 2144 attack on Earth by extraterrestrials</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>";

        Document document = Jsoup.parse(response);
               int index=0;
        for (Element table : document.select("table")) {

            for (Element row : table.select("tr")) {
                System.out.println("Row\t" + (++index));
                Elements tds = row.select("td");
                System.out.println("TD\t" +tds.get(0).text()+":"+tds.get(1).text());
            }
        }

    }


}