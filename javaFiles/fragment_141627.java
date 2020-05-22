private static String capitalize(String str){
    StringBuilder s = new StringBuilder();
    char ch;
    for(int i = 0;i<str.length();i++) {
        ch = str.charAt(i);
        if(i==0 && Character.isLowerCase(ch)) {
            s.append(Character.toUpperCase(ch));
        } else {
            s.append(Character.toLowerCase(ch));
        }
    }
    return s.toString();
}