int i = 0;
for(ArrayList<Integer> a1 : outer){
    int j=0;
    for(Integer k : a1){
       yourarray[i][j++] = k;
    }
    i++;
}