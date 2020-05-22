public List<String> findRepeatedDnaSequences(String s) {
    Set<String> res = new HashSet<String>();

    if(s == null || s.length() == 0){
        return new ArrayList<String>();
    }

    for(int i = 0; i < s.length() - 10; i++){
        String sub = s.substring(i, i+10);
        System.out.print(occurance(s,sub) + ",");
        if(!res.contains(sub) && occurance(s,sub) > 1){
            res.add(sub);
        }
    }
    return new ArrayList<String>(res);
}