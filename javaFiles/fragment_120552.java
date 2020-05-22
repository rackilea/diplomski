List<String> list = new ArrayList<String>();
int strLen = str.length();

for (int i = 0; i < strLen; i++) {
    char c = str.charAt(i);

    if (c == '{') {
        int b = 1;
        StringBuilder sb = new StringBuilder("{");

        while (b > 0 && i < strLen - 1) {
            sb.append( c = str.charAt(++i) );

            if (c == '}') b--;
            else if (c == '{') b++;
        }
        list.add(sb.toString());
    }
}

for (String s : list) { System.out.println(s); }