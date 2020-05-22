public static void main(final String[] args) throws Exception {
    final String[] loginURLs = {
        "http://ip:port/path?username=abcd&location={LOCATION}&TXT{UE-IP,UE-Username,UE-Password}&password={PASS}",
        "http://ip:port/path?username=abcd&location={LOCATION}&password={PASS}&TXT{UE-IP,UE-Username,UE-Password}",
        "http://ip:port/path?TXT{UE-IP,UE-Username,UE-Password}&username=abcd&location={LOCATION}&password={PASS}",
        "http://ip:port/path?TXT{UE-IP,UE-Username,UE-Password}",
        "http://ip:port/path?username=abcd&password={PASS}"};
    final Pattern patt = Pattern.compile("(\\?)?&?(TXT\\{[^}]++})(&)?");
    for (final String loginURL : loginURLs) {
        System.out.printf("%1$-10s %2$s%n", "Processing", loginURL);
        final StringBuffer sb = new StringBuffer();
        final Matcher matcher = patt.matcher(loginURL);
        while (matcher.find()) {
            final String found = matcher.group(2);
            System.out.printf("%1$-10s %2$s%n", "Found", found);
            if (matcher.group(1) != null && matcher.group(3) != null) {
                matcher.appendReplacement(sb, "$1");                
            } else {
                matcher.appendReplacement(sb, "$3");
            }
        }
        matcher.appendTail(sb);
        System.out.printf("%1$-10s %2$s%n%n", "Processed", sb.toString());
    }
}