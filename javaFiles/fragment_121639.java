String input = "<head>\n" +
        "\n" +
        "    <script type=\"text/javascript\">window._timings = {\"domLoading\": Date.now()}</script>\n" +
        "\n" +
        "        <meta charset=\"utf-8\">\n" +
        "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "<script type=\"text/javascript\">window._sharedData = {\"country_code\": \"IR\", \"language_code\": \"en\", \"gatekeepers\": {\"cc\": true, \"sms\": true, \"ra\": true}, \"show_app_install\": false, \"static_root\": \"//instagramstatic-a.akamaihd.net/h1\", \"platform\": \"web\"};</script>\n" +
        "<script src=\"//instagramstatic-a.akamaihd.net/h1/bundles/en_US_ProfilePage.js/88ce62d41e70.js\" type=\"text/javascript\" crossorigin=\"anonymous\"></script>";
System.out.println(between("window._sharedData =", "}", input));