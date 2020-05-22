Elements imgElements = doc.select("img");
        for (Element element : imgElements) {
            element.attr("src", "http://HERE_IS_MY_DOMAIN.com?"+element.attr("abs:src"));
        }

        Elements hrefElements = doc.select("a");
        for (Element element : hrefElements) {
            element.attr("href", "http://HERE_IS_MY_DOMAIN.com?"+element.attr("abs:href"));
        }

        Elements linkElements = doc.head().select("link");
        for (Element element : linkElements) {
            element.attr("href", "http://HERE_IS_MY_DOMAIN.com?"+element.attr("abs:href"));
        }