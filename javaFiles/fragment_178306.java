String s = "abcdefghijklmnopqrstuvwxyzAEIOUY";

    // replace all vowels 
    s = s.replaceAll("[aeiouyYAEIOU]","");
    s = s.replaceAll("([a-zA-z])", ".$1");
    System.out.println(s);