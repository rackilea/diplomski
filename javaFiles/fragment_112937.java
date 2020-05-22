List<String> strs = Arrays.asList("(someName,true), (anything,false), (pepe12,true);","(hola,false);","comosoy12,true);", "(batman,true), (kittycat,false);", "(batman,true); (kittycat,false);");
String block = "\\(\\w+,(?:true|false)\\)";
String regex = block + "(?:,\\s+" + block + ")*;";
Pattern p = Pattern.compile(regex);
for (String str : strs)
    System.out.println(str + " => " + p.matcher(str).matches());