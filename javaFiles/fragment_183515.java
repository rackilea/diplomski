Document document = Jsoup.parse(new File("some.html"),"utf-8");
    Element message = document.select("div.message").first();
    Element span = document.select("span.date-time").first();
    Element comments = document.select("div.comments").first();
    Element h4 = document.select("h4.direction1").first();
    Element test = document.select("div.comments").select("div.message")
                    .first();

    System.out.println(message.text());
    System.out.println(span.text());
    System.out.println(comments.text());
    System.out.println(h4.text());
    System.out.println(test.text());