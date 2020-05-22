public static int[] generierePrimzahlen(int bis){
int [] myAry = new int[bis];
// Arrays.fill(myAry,0);    // no need, this is already been done at initialization
for(int i=0;i<myAry.length;i++){
  int counter = 0;

         // adding <= 'nextprime <= bis;' to check also the last number in the range
      for (int nextprime=1; nextprime <= bis; nextprime++){
         // int counter = 0; wrong scope
         // System.out.println(nextprime);
          if (istPrimzahl(nextprime)){
              myAry[counter] = nextprime;
              counter++;
          }

   }
    if(myAry[0] != 0)    // to get rid of displaying Zeros
       System.out.print(myAry[i]+" ");
  }

return myAry;


}