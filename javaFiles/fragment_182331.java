for(int i = 0; i < chars.length; i++){
    boolean matches = true;
    for(int j = 0; j < pattern.length; j++){
        if((i+j) >= chars.length || chars[i+j] != pattern[j]){
            matches = false;
            return;
        }
    }
    if(matches)
        return true;
}
return false;