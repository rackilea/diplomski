Pattern p = Pattern.compile("content=\"WordPress\\s+([\\d.]+)\"");
Matcher m = p.matcher(line);
if(m.find())
     System.out.println(m.group(1));
else
     System.out.println("not found");