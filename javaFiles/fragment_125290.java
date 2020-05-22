String html = "<body.content>\n"
        + "  <block class=\"lead_paragraph\">\n"
        + "    <p>LEAD: Two police officers responding to a reported robbery at a Brooklyn tavern early yesterday were themselves held up by the robbers, who took their revolvers and herded them into a back room with patrons, the police said.</p>\n"
        + "  </block>\n"
        + "  <block class=\"full_text\">\n"
        + "    <p>LEAD: Two police officers responding to a reported robbery at a Brooklyn tavern early yesterday were themselves held up by the robbers, who took their revolvers and herded them into a back room with patrons, the police said.</p>\n"
        + "  </block>";
Document doc = Jsoup.parse(html);
String link = doc.select("block.full_text").text();
System.out.println(link);