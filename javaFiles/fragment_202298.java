String htmlString = "<message id=\"dsds\" to=\"test@test.com\" type=\"video\" from=\"test@test\"><body>TESTTESTTEST</body><active xmlns=\"http://jabber.org\"/></message>";
    String bodyText="";
    Pattern p = Pattern.compile("<body.*>(.*?)</body.*>");
    Matcher m = p.matcher(htmlString);

    if (m.find()) {
        bodyText = m.group(1);
    }
    System.out.println(bodyText);