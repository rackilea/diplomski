String source = "<span class=\"zg_hrsr_ladder\">in&nbsp;<a href=\"https://www.amazon.de/gp/bestsellers/books/ref=pd_zg_hrsr_b_1_1\">B&uuml;cher</a> &gt; <a href=\"https://www.amazon.de/gp/bestsellers/books/287480/ref=pd_zg_hrsr_b_1_2\">Krimis & Thriller</a> &gt; <b><a href=\"https://www.amazon.de/gp/bestsellers/books/419954031/ref=pd_zg_hrsr_b_1_3_last\">Deutschland</a></b></span>";

Document htmlDocument = Jsoup.parse(source, "UTF-8");

Elements category = htmlDocument.select("span.zg_hrsr_ladder a");

category.forEach(aElement -> {
    System.out.println(aElement.text());
});