String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
Response res = Jsoup
        .connect("http://www.soccerpunter.com/soccer-statistics/England/Premier-League-2016-2017/")
        .followRedirects(true).userAgent(userAgent).referrer("http://www.soccerpunter.com")
        .method(Method.GET).header("Host", "http://www.soccerpunter.com").execute();

Document doc = Jsoup
        .connect("http://www.soccerpunter.com/soccer-statistics/England/Premier-League-2016-2017/head_to_head_statistics/all/676_Manchester_City_FC/661_Chelsea_FC")
        .userAgent(userAgent).timeout(10000).header("Host", "http://www.soccerpunter.com")
        .cookies(res.cookies())
        .referrer("http://www.soccerpunter.com/soccer-statistics/England/Premier-League-2016-2017/")
        .get();

Elements td = doc.select("table.competitionRanking.tablesorter").first().select("td");