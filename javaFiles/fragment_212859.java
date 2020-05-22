//w denotes lookup word
isSubWord(w){
  i=0;
  cnt=0;
  while(i!=w.length){
    if(f(i+cnt)==w(cnt)){
      ++cnt;
    }else{
      cnt=0;
      ++i;
    }
}