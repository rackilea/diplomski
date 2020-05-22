String html =
        "<html><script> var uitkformatter = { dependency: ['uitk_localized_dateApi', 'uitk_localized_priceApi', 'uitk_localized_config'] }; </script><script async defer src=\"//www.expedia.com/i18n/28/en_US/JPY/currencyFormats.js?module=exp_currencyformats_JPY\"></script><script> define('exp_currencyformats', [ 'exp_currencyformats_JPY' ], function() { return window.uitkformatter; }); </script><script async defer src=\"//b.travel-assets.com/uitoolkit/2-164/3542359672ff5cd9d827c16bd754bf539fd383b1/core/js/uitk-localize-bundle-min.js\"></script>\n" +
                "<script language=\"javascript\" type=\"text/javascript\">\n" +
                "OlAltLang = 'en-us.';\n" +
                "</script>\n" +
                "<script type=\"text/javascript\">\n" +
                "'use strict';\n" +
                "require('infositeApplication', function(infositeApplication) {\n" +
                "infositeApplication.start();\n" +
                "});\n" +
                "define('infosite/env', function() {\n" +
                "return {\n" +
                "isJP: true,\n" +
                "isVN: false,\n" +
                "isVSC:false,\n" +
                "isTD:false\n" +
                "};\n" +
                "});\n" +
                "define('infositeData', [], function() {\n" +
                "var infosite = {};\n" +
                "infosite.hotelId = '5522663';\n" +
                "infosite.guid = '59ad4387-979f-477a-901a-6070f3879ce6';\n" +
                "infosite.token = '6a06f2f73106c754340f7a459f5d75d588637caa'; </script></html>";

Document doc = Jsoup.parse(html);

Elements scriptElements = doc.getElementsByTag("script");

// the script elements have no identifying charateristic so we must loop
// until we find the one which contains the "infosite.token" variable
for (Element element : scriptElements) {
    if (element.data().contains("infosite.token")) {
        // find the line which contains 'infosite.token = <...>;'
        Pattern pattern = Pattern.compile(".*infosite\\.token = ([^;]*);");
        Matcher matcher = pattern.matcher(element.data());
        // we only expect a single match here so there's no need to loop through the matcher's groups
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        } else {
            System.err.println("No match found!");
        }
        break;
    }
}