public void printIf(int value, int div){
      printIfMod(value, div);
      printIfDiv(value, div);
 }

 for(int i = 1; i < 100; i++) {
      printIf(i, 3);
      printIf(i, 5);
      ....
 }