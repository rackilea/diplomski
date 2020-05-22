(^|\s)'|'(\s|$)

Pattern p = Pattern.compile("(^|\\s)'|'(\\s|$)");
Matcher m = p.matcher("quick 'brown' fox jump's over 'the' lazy dog");
int cnt = 0;
while(m.find()) {
    cnt++;
}
System.out.println(cnt);