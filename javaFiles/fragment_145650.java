for (int i=0;i<numbers.length;i++){
     for (int j=2;j<numbers.length;j++){
          if (target-numbers[i]-numbers[j]==0){return true;}
     }
     if (target-numbers[i]==0){ return true;}
     curr+=target[i];
}
return false;