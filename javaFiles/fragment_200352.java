//one liner to read data from file (don't bother with it now)
String input = new Scanner(new File("input.txt")).useDelimiter("\\A").next();

//we want to find `Get /[no-whitespace-characters]+.html`
Pattern p = Pattern.compile("GET (/\\S+\\.html)");
Matcher m = p.matcher(input);
while(m.find())
    System.out.println(m.group(1));