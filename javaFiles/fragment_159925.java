try {
    int a = 0;
    boolean condition = true;
    while (a < 30 && condition) {

        try{
            doc = Jsoup.connect("http://www.google.com" + a).get();
        } catch(Exception jsoupE){
            continue;
        }

        Elements info = doc.select("td[valign=top]");
        if (info.first() != null) {
            System.out.println(info);
            condition = false;
            System.out.println(a);
        } else {
        a = a + 1;
        }
    }
} catch (Exception e) {
}