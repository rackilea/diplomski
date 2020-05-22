public List<String> findRepeatedDnaSequences(String s) {
    Set<String> dup = new HashSet<String>();
    Set<String> res = new HashSet<String>();

    if(s == null || s.length() == 0){
        return new ArrayList<String>();
    }

    for(int i = 0; i < s.length() - 10; i++){
        String sub = s.substring(i, i+10);
        if(!dup.add(sub)) { 
            res.add(sub); // add sub to res only if it is already present in dup
        }
    }
    return new ArrayList<String>(res);
}