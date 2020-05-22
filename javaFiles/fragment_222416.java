static final Pattern p = Pattern.compile(
        "([0-9]{8})"
        +"([0-9]{3})"
        +"([0-9]{3})"
        +"([0-9]{2})"
        +"([0-9]{2})"
        +"([0-9]{3})"
        +"([0-9]{2})"
        +"([0-9]{20})"
        +"([0-9]{5})"
        +"([0-9]{1})");

private void test(String[] args) {
    // NB: I added one more 0 at the start.
    Matcher m = p.matcher("0000000900100103010330200000005677890212126000020");
    if ( m.find() ) {
        for ( int i = 1; i <= m.groupCount(); i++ ) {
            System.out.print(m.group(i)+" ");
        }
    }
}