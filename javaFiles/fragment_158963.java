String text = "abcdefghijklmnopqrstuvwxyz0123456789!$%^&*()äöü";

for (int i = 0; i < text.length(); i++) {
    char ch = text.charAt(i);
    ch--;
    if (ch % 32 < 13)
        ch += 13;
    else if (ch % 32 < 26)
        ch -= 13;
    else if (ch % 32 < 29)
        ch += 3;
    else
        ch -= 3;
    ch++;
    System.out.print(ch);
}