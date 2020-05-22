for(int i = 0; i < x; i++){
   System.out.print("Enter number of elements for array: ");
   int s = input.nextInt();
   input.nextLine();
   array[i] = new String[s]; 

   for(int j = 0; j < s ; j++){ 
      System.out.print("Enter string: ");
      String word = input.nextLine();
      array[i][j] = word;
   }