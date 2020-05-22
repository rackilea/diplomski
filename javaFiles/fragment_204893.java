String url = "http://www.xboxachievements.com/";

Document doc = Jsoup.connect(url).get();
Elements methodOne = doc.select("div.bl_me_main");
Elements methodTwo = doc.getElementsByClass("bl_me_main");

System.out.println(methodOne.size());
System.out.println(methodTwo.size());