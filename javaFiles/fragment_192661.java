void printarray(int i)
  {
    if(i==0)
        return ; 
    else printarray(i-1);
//printarray(i-1) here it calls the method itself so as to print all the values recursively 
    System.out.print(values[i-1]+" ");
  }