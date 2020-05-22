final String url = "http://www.amazon.com/gp/rss/movers-and-shakers/appliances/ref=zg_bsms_appliances_rsslink";
    Document doc = Jsoup.connect(url).get();


    for( Element item : doc.select("item") ) // Select all items
    {
        final String title = item.select("title").first().text(); // select the 'title' of the item
        final String link = item.select("link").first().nextSibling().toString().trim(); // select 'link' (-1-)

        final Document descr = Jsoup.parse(StringEscapeUtils.unescapeHtml4(item.select("description").first().toString()));
        final String price = descr.select("span.price").first().text(); // select 'price' (-2-)

        // Output - Example
        System.out.println(title);
        System.out.println(link);
        System.out.println(price);
        System.out.println();
    }