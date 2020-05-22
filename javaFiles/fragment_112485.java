String id = null;
if (uri != null) {
    UrlQuerySanitizer urlQuerySanitizer = new CustomUrlQuerySanitizer();

    urlQuerySanitizer.registerParameter("id",
            new UrlQuerySanitizer.IllegalCharacterValueSanitizer(
                    UrlQuerySanitizer.IllegalCharacterValueSanitizer.ALL_OK
            ));
    urlQuerySanitizer.parseUrl(uri.toString());
    id = urlQuerySanitizer.getValue("id");