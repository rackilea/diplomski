HashMap<Character, Boolean> ht=new HashMap<Character, Boolean>();
    for(int i=0; i<s.length(); i++){
        if(!ht.containsKey(new Character(s.charAt(i))))
            ht.put(new Character(s.charAt(i)),true);
        else
            return false;
    }
    return true;