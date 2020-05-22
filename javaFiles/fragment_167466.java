String html = "<p><a href='ftp://example.com/' onfocus='invalidLink()'>Link</a></p><a href='ftp://example2.com/'>Link 2</a>";

// * Custom whitelist
Whitelist myReportEnabledWhitelist = new MyReportEnabledWhitelist()
    // ** Basic whitelist (from Jsoup)
    .addTags("a", "b", "blockquote", "br", "cite", "code", "dd", "dl", "dt", "em", "i", "li", "ol", "p", "pre", "q", "small", "span",
                "strike", "strong", "sub", "sup", "u", "ul") //

    .addAttributes("a", "href") //
    .addAttributes("blockquote", "cite") //
    .addAttributes("q", "cite") //

    .addProtocols("a", "href", "ftp", "http", "https", "mailto") //
    .addProtocols("blockquote", "cite", "http", "https") //
    .addProtocols("cite", "cite", "http", "https") //

    .addEnforcedAttribute("a", "rel", "nofollow") //

    // ** Customizations
    .addTags("body") //
    .addProtocols("a", "href", "tel", "device") //
    .removeProtocols("a", "href", "ftp");

boolean safeCustom = Jsoup.isValid(html, myReportEnabledWhitelist);
System.out.println(safeCustom);