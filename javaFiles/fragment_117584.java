String html = "<img width='300' height='246' src='http://mesrobian.sarnok.com/wp-content/uploads/2013/11/rayi_slleiman_bkerke-300x246.jpg'" +
                " class='attachment-medium wp-post-image' alt='rayi_slleiman_bkerke' style='float: right; margin-left: 5px;' /><p><strong>Lorem Ip" +
                "sum</strong> is simply dummy text of the priectronic typesetting, remaining essentially unchanged. It was popularised in the 1960" +
                "s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Al" +
                "dus PageMaker including versions of Lorem Ipsum.</p> <p><strong>Lorem Ipsum</strong> is simply dummy text of the priectronic type" +
                "setting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ip" +
                "sum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>";

        Document doc = Jsoup.parse(html);
        Elements paragraphs = doc.select("p");      
        System.out.println(paragraphs);