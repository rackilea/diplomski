public static void main(String args[])
   {
      int n;
      int status = 1;
      int num = 3;
      List<Integer> primeNumberList=new ArrayList<Integer>();
      //For capturing the value of n
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the value of n:");
      //The entered value is stored in the var n
      n = scanner.nextInt();
      if (n >= 1)
      {
         System.out.println("First "+n+" prime numbers are:");
         //2 is a known prime number
         System.out.println(2);
         primeNumberList.add(2);
      }

  for ( int i = 2 ; i <=n ;  )
  {
     for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
     {
        if ( num%j == 0 )
        {
           status = 0;
           break;
        }
     }
     if ( status != 0 )
     {
        System.out.println(num);
        primeNumberList.add(num);
        i++;
     }
     status = 1;
     num++;
  }

  //reversing collection 
  Collections.reverse(primeNumberList);
   System.out.println("\n");
  System.out.println("Alternate Prime numbers in reverse order \n");
  for(int k=0;k<primeNumberList.size();k++){
     if((k%2)==0)
          System.out.println(""+primeNumberList.get(k));
  }