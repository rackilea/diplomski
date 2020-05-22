String html = "<span style=\"display:none\">&amp;0000000000000217000000</span>";
html += "<span style=\"display:none\">&amp;1111111111111111111111111</span>";
html += "<p>Test paragraph should not be removed</p>";

Document doc = Jsoup.parse(html);

doc.select("span[style*=display:none]").remove();

System.out.println(doc);