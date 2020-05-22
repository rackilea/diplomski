final static int PROD_POS = 1;
final static int STATE_POS = 3;

...

Pattern pattern = Pattern.compile("(some_regexp)-(some_regexp)-(some_regexp)");
Matcher matcher = pattern.matcher(input);

if ( matcher.matches() ) {
    String state = matcher.group(STATE_POS);
}