for(int i = 0; i<s.length(); i++){
    char cur = s.charAt(i);
    if(base >= 0 && base <= 9){
        ret = ret * base + (cur - '0');
    }
}