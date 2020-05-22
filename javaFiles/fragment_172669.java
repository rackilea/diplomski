String html = "<table id=\"timetable\" class=\"table gradient-table\">\n<tbody>\n    <tr>\n      <td  class=\"time\">\n      <div>10:30 12:05</div>\n      </td>\n      <td  class=\"time\">\n      <div>12:30 14:05</div>\n      </td>\n      <td  class=\"time\">\n      <div>12:30 14:05</div>\n      </td>\n      <td  class=\"time\">\n      <div>14:30 16:05</div>\n      </td>\n      <td  class=\"time\">\n      <div>16:30 18:05</div>\n      </td>\n    </tr>\n</tbody>\n</table>";

Document doc = Jsoup.parse(html);

for (Element elt : doc.select("table#timetable > tbody > tr > td.time")) {
    System.out.println(elt.text());
}