int i = 0;
while(word.indexOf(i, letter) != -1) {
   i = word.indexOf(i, letter) + 1;
   //Do whatever
}

if(i == 0) {
   //Handle missed letter 
}