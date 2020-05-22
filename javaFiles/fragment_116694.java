Pattern p = Pattern.compile("Topic1</(.+?)>(.*?)<\\1>");
    //  get a matcher object
    Matcher m = p.matcher("<b>Topic1</b><ul>asdasd</ul><br/><b>Topic2</b><ul>");
    while(m.find()) {
        System.out.println(m.group(2));  // <ul>asdasd</ul><br/>
    }