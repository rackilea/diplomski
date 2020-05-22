public boolean isAnyEmpty(String... strArr){
    for(String s : strArr){
        if(s.equals("")) return true;
    }
    return false; 
}