String url = "http://megatokyo.com/strip/1456";

Element base = doc.select("head > base[href]").first();

String baseUrl = base!=null ? base.attr("href") : url;

Element ele = doc.select("#comic > div > div.navcontrols.top > ul > li.next > a").first();
ele.setBaseUri(baseUrl);

System.out.println(ele.attr("abs:href"));