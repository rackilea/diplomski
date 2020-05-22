public int pigLatRules(String r){
    final String[] vowels={"a","A","e","E","i","I","o","O","u","U"};
    for(int i = 0; i< vowels.length; i++){
        if(r.startsWith(vowels[i])){
             return 0;
         }
    }
    return 1;
}