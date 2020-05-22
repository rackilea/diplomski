String pattern = "(^$|[a-z0-9\\-\\_]*)(\\s+)([A-Z]+)(\\s+)([a-z0-9\\-\\_]*)"; 

Pattern r = Pattern.compile(pattern);

String line = "";
Matcher m;
while((line = tmp.nextLine()) != null) {
    m = r.matcher(line);
    while(m.find()) {
        System.out.println(m.group(1) + m.group(2)+ m.group(3)+ m.group(4)+ m.group(5));
    }
}