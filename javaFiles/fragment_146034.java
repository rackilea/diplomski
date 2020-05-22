private static String shift(String p, int shift){
    StringBuilder s = new StringBuilder();  //better using a mutable object than creating a new string in each iteration
    int len = p.length();
    for(int x = 0; x < len; x++){
        char c = p.charAt(x);  //no need for casting
        if (c != ' '){ // this should work now
            c += shift;
            if (c > 'z'){ //we assume c is in the 'a-z' range, ignoring 'A-Z'
                c -= 'z';
            }
        } 
        s.append(c);
    }
    return s.toString();
}