List<String> subTreeList = new ArrayList<String>();
String s = getMyString();
int level = 0;
int lastOpenBracket = -1
for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    if (c == '(') {
        level++;
        if (level == 1) {
            lastOpenBracket = i;
        }
    } else if (c == ')') {
        if (level == 1) {
            subStreeList.add(s.substring(lastOpenBracket, i);
        }
        level--;
    }
}

I haven't checked it works, and you should debug it. You should also put checks to make sure you