Pattern p = Pattern.compile("(.+) has wrote\\s?(?:\\((\\d\\d):(\\d\\d)\\))?");

Matcher m = p.matcher("Gareth has wrote (12:00)");

if( m.matches()){
    System.out.println(m.group(1));
    System.out.println(m.group(2));
    System.out.println(m.group(3));
}

m = p.matcher("Gareth has wrote");
if( m.matches()){       
    System.out.println(m.group(1));
    // m.group(2) == null since it didn't match anything
}