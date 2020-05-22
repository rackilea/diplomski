String html = "<html><head><body><div id=\"nameofPlayer\">Star Crafter</div></body></html>";

    // strip out your required data with a regex
    Pattern pattern = Pattern.compile(".*<div id=\"nameofPlayer\">(.*?)</div>.*");
    Matcher matcher = pattern.matcher(html);

    if (matcher.find()) {
        System.out.println(matcher.group(1));
    }