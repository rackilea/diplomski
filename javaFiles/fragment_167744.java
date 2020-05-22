char[] charBin = new char[size];
int move = -1;
...
for(int i=0;i < size ; i++) {
   for(int j=0;j < 17;j++) {
      move++;
      if(charBin[move]) ...
   }
}