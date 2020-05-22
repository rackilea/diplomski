if (text1 < 'A' || (text1 < 'a' && line.charAt(i) > 'a')) {
    text1 = text1 + 26;
    text2 = (char)text1;
    text3 = Character.toString(text2);
    text4 += text3;
}