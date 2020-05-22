jshell> Pattern patter = Pattern.compile("C(?:\\s\\d+){2}|[LR](\\s\\d+){4}|Q")
patter ==> C(?:\s\d+){2}|[LR](\s\d+){4}|Q
jshell> Matcher matcher = patter.matcher("C 10 10");
matcher ==> java.util.regex.Matcher[pattern=C(?:\s\d+){2}|[LR ... }|Q region=0,7 lastmatch=]
jshell> matcher.matches()
$9 ==> true
jshell> Matcher matcher = patter.matcher("L 1 2 6 2");
matcher ==> java.util.regex.Matcher[pattern=C(?:\s\d+){2}|[LR ... }|Q region=0,9 lastmatch=]
jshell> matcher.matches()
$11 ==> true
jshell> Matcher matcher = patter.matcher("R 14 1 8 3");
matcher ==> java.util.regex.Matcher[pattern=C(?:\s\d+){2}|[LR ... |Q region=0,10 lastmatch=]
jshell> matcher.matches()
$14 ==> true
jshell> Matcher matcher = patter.matcher("Q");
matcher ==> java.util.regex.Matcher[pattern=C(?:\s\d+){2}|[LR ... }|Q region=0,1 lastmatch=]
jshell> matcher.matches()
$15 ==> true