String html = "<p>aaa</p>" +
        "<p>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</p>" +
        "<p>cccc</p>" +
        "<p>d</p>";

Document doc = Jsoup.parse(html);
Elements e = doc.select("p:matches(^.{3,30}$)");

System.out.println(e);