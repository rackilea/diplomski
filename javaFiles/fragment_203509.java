for(int i = 0; i < w.length(); i++){
    c = w.charAt(i);
    c = Character.toLowerCase(c);
    if(c > 96 && c < 123){
        c = (char)(c - key);
        if(!(c > 96)){
            c = (char) (c + 26) ;
        }
    }
    temp = temp + "" + Character.toString(c);
}