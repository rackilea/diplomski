Pattern p = Pattern.compile("(?:(\\d+)|([^,]+))(?=,|$)");
Matcher m = p.matcher("foo3,1234,4bar,12,12foo34");

while (m.find()) {
    System.out.println(m.group(1) != null 
        ? "Number: " + m.group(1)  
        : "Non-Number: " + m.group(2));
}