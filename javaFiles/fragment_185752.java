String regex = ".*\\[LoadFile\\]\\s+file\\s+=\\s+\"([^\"].+)\".*";

Matcher m = Pattern.compile(regex).matcher(inputString);
if (!m.find()) 
    System.out.println("No match found.");
else
    String result = m.group(1);