Document doc = Jsoup.connect("https://www.bezaat.com/ksa/riyadh/cars/all/1").get();
   Elements elements = doc.select("div.adv_item");
   for (Element el : elements) {
       System.out.println(el.select(".adv_content_details").text());
       System.out.println(el.select(".adv_side_price").text().replace("ريال", ""));
   }