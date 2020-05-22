public ArrayList<Integer> correctWord (char[] n,String word,char c){
    ArrayList<Integer> indexes = new ArrayList<Integer>();
    int index=0;
    for(int i =0; i < word.length();i++){
        if( c == n[i]){
            indexes.add(i);
        }            
    }

    return indexes;
}