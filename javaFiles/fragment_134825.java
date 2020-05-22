char[] numArray = num.toCharArray();
  int counter=0;
  for(int i=0;i<numArray.length;i++) {
     if(numArray[i]=='0') {
        counter++; 
     }
     if((i==numArray.length-1&&counter>0)||(counter>0&&numArray[i]!='0')) {
        System.out.println("Number of Zeroes: "+counter);
        counter=0;
     }
  }