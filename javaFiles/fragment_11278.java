for(int i = 0; i<= line.length()-1; i++) {
    if (Character.isLetter(line.charAt(i))) {
        int text1 =  line.charAt(i) - (key.charAt(j%(key.length()))-'a');  

        if (text1 < 'A' || (text1 < 'a' && line.charAt(i) > 'a')) {
            text1 = text1 + 26;
        }
        text4 += (char)text1;
        j++;
    } else {
        text4 += line.charAt(i);
    }
}