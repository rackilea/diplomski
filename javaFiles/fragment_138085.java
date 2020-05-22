int win = 0;
int tally = 7;

for(int i=0; i<k-1; i++){
  for(int j=i+1; j<k; j++){
    if(array[i]+array[j] == tally){
      win++;
    }
  }
}