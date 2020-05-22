Pattern p = Pattern.compile("(.+) has wrote \\((\\d\\d):(\\d\\d)\\)");

Matcher m = p.matcher("Gareth has wrote (12:00)");

if( m.matches()){
    System.out.println(m.group(1));
    System.out.println(m.group(2));
    System.out.println(m.group(3));
}