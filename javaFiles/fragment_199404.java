// connect to url and retrieve source code as document
    Document doc = Jsoup
            .connect(url)
            .userAgent("Mozilla/5.0")
            .referrer("http://www.google.com")
            .get();

    String md5= doc

            // use CSS selector to grab only enums which contain md5
            .select("div#file-details.extra-info > div.enum-container > div.enum:contains(md5)")

            // use the first element in the result set
            .first()

            // use only its text node and ignore the text node of the span
            .ownText();