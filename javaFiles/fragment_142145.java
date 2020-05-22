public static String replaceKth(char a, char b, int k, String c){
    StringBuilder builder = new StringBuilder(c);
    int occ = 0;
    for(int i = 0; i < c.length(); i++){
        if (c.charAt(i) == a){
            occ = occ + 1;
            if(occ == k){
                builder.setCharAt(i, b);
            }
        }
    }
    return builder.toString();
}