ArrayList<Integer> arraylistPage1;

for(int j=1;j<=totalPage;j++){  
 int x=0;
 arraylistPage1 = new ArrayList<Integer>(rangeMode);
 for(int i=1;i<=rangeMode;i++){
      if(binaryTable[i][j]==1){
         cardInPage[j][x]=i;
         System.out.println("card number: "+i);
         arraylistPage1.add(i);
         System.out.println(arraylistPage1);
         x++;                   
      }
 }
 System.out.println("page-"+j+" total card:"+x);
 totalCardInPage[j]=x;
}