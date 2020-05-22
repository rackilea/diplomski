String regex = "^https://www.mydomain.com/myView\\?[a-zA-Z0-9~!';@#\\^\\$%&\\*\\(\\)-_\\+=\\[\\]\\{\\}\\|\\\\,\\.\\?\\s]+";

    String validUrlchars = "[a-zA-Z0-9~!';@#\\^\\$%&\\*\\(\\)-_\\+=\\[\\]\\{\\}\\|\\\\,\\.\\?\\s]";

    String url1 = "https://www.mydomain.com/myView?z";
    String url2 = "https://www.mydomain.com/myView?";
    String url3 = "https://www.mydomain.com/myView";
    String url4 = "https://www.mydomain.com/myViewfdgdfgfd";
    String url5 = "https://www.mydomain.com/myView?a=hello&b=world&c=how&d=are&e=you";
    String url6 = "https://www.mydomain.com/myView?a=hello&b=world&c=how&d=are&e=(you)";

    Pattern p = Pattern.compile(regex);
    Matcher m;
    m = p.matcher(url1);
    System.out.println(m.matches() + " " + url1);
    m = p.matcher(url2);
    System.out.println(m.matches() + " " + url2);
    m = p.matcher(url3);
    System.out.println(m.matches() + " " + url3);
    m = p.matcher(url4);
    System.out.println(m.matches() + " " + url4);
    m = p.matcher(url5);
    System.out.println(m.matches() + " " + url5);
    m = p.matcher(url6);
    System.out.println(m.matches() + " " + url6);