String s = "go to med!!";
String alphabetS = "abcdefghijklmnopqrstuvwxyz";

String[] words = s.split(" ");
StringJoiner sj = new StringJoiner(" ");
for (String word : words) {
    StringBuilder sb = new StringBuilder(word);
    for (int i = 0; i < sb.length(); i++) {
        char currChar = sb.charAt(i);

        int idx = alphabetS.indexOf(currChar);
        if (idx != -1) {
            if (i % 2 == 1) {
                sb.setCharAt(i, '*');
            }
        }

    }
    sj.add(sb.toString());
}
System.out.println(sj.toString());