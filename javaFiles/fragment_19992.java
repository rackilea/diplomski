String loginUrl = "https://accounts.google.com/Login?hl=pl#identifier";
  Connection.Response res = Jsoup.connect(loginUrl)
          .data("Email", MYMAIL)
          .execute();

  Connection.Response res2 = Jsoup.connect(loginUrl)
          .cookies(res.cookies())
          .data("Passwd", MYPASS)
          .execute();


  Document page = Jsoup
            .connect("https://adwords.google.com/")
            .cookies(res2.cookies()) 
            .get();

  System.out.println(page.toString());