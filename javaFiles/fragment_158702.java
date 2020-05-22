String test = "https://www.google.com/https://www.yahoo.com/https://facebook.com/";

    String[] urls = test.split("(?<!/)/(?!/)");

    for(String s:urls){

        System.out.println(s);
    }