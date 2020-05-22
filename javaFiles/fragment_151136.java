String input = "<title>Replacing keywords with keyword</title>\n"+
               "<body>\n"+
               "<h2>Titles</h2>\n"+
               "<p>Par with keywords and keyword</p>\n"+
               "<h2>Titles</h2>\n"+
               "<p>Par with keywords and keyword</p>\n"+
               "</body>";
String regex = "(?s)(<\\/h2.+)\\b(keyword)\\b(?=.*<\\/h2>.*$)";
String keytoreplacewith = "NEW_COOL_KEYWORD";
String output = input.replaceFirst(regex, "$1"+keytoreplacewith);
System.out.println(output);