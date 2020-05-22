String text = "lat:54.897601 lon:4.707973\n" +
            "speed:0.03\n" +
            "T:18/10/11 13:52\n" +
            "http://maps.google.com/maps?f=q&q=54.897601,4.707973&z=16\n" +
            "Pwr: ON Door: OFF ACC: OFF";

    String urlStr = text.substring(text.indexOf("http://maps.google.com"), text.indexOf("\n", text.indexOf("http://maps.google.com")) != -1 ? text.indexOf("\n", text.indexOf("http://maps.google.com")) : text.length());
    System.out.println(urlStr);