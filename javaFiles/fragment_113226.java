String delim = "|";
String esc = "+";
String regex = "(?<!" + Pattern.quote(esc) + ")" + Pattern.quote(delim);

for (String s : "A|B|C|The Steading+|Keir Allan+|Braco|E".split(regex))
    System.out.println(s);