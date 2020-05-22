String text = "laksjdlkja\"a$b$c\"askjd\"asdafar\"rafs$\"asdk\"xx$re$odiff\"kdf";
String pattern = "[^\"$]+\\$[^\"$]+\\$[^\"$]+";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(text);
while (m.find()) {
     System.out.println("Found match: " + m.group(0));
}

Found match: a$b$c
Found match: xx$re$odiff