public int size(TrieNode tmp, int n){

    int sum = 0;
    for(int i=0;i<tmp.children.size();i++){
        sum +=  size(tmp.children.get(i), n);
    }

    if(/* node has char n */){
      return sum + 1;
    }
    return sum ;
}