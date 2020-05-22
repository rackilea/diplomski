for(int i = 1; i<S.length; i++){
    if(S[i] != null) {
        int prio= S[i].getPrioritet();   <-- nullpointer excp.
        if(prio<temp.getPrioritet()){
            temp = S[i];
        }
     }
}