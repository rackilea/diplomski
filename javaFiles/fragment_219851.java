Pattern p = Pattern.compile("\\w+ (\\d+) [\\w ]+ (\\d{2}:\\d{2})");
Matcher m = p.matcher(oneline);
if(m.matches()) {
    System.out.println("The quantity is " + m.group(1));
    System.out.println("The time is " + m.group(2));
}