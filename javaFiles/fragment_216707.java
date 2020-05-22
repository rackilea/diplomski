String s = "go to med!!";
String alphabetS = "abcdefghijklmnopqrstuvwxyz";

StringBuilder sb = new StringBuilder(s);
int counter = 0;
for (int i = 0; i < sb.length(); i++) {
    char currChar = sb.charAt(i);

    int idx = alphabetS.indexOf(currChar);
    if (idx != -1) {
        if (counter % 2 == 1) {
            System.out.println("!!");
            sb.setCharAt(i, '*');
        }
        counter++;
    }

}
System.out.println(sb.toString());