String data = "Hello there, my name is not importnant right now."
        + " I am just simple sentecne used to test few things.";
int maxLenght = 10;
Pattern p = Pattern.compile("\\G\\s*(.{1,"+maxLenght+"})(?=\\s|$)", Pattern.DOTALL);
Matcher m = p.matcher(data);
while (m.find())
    System.out.println(m.group(1));