int[] numbers = new int[10];

  //storing all the numbers in an array
  for(int i = 0; i < 10; ++i)
      numbers[i] = in.nextInt();

  //checking each one
  for(int i = 0; i < numbers.length; ++i) {
     if(numbers[i] % 2 == 0 )
         System.out.println("No");//even
     if(numbers[i] % 2 == 1 )
         System.out.println("Yes");//odd
  }