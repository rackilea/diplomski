System.out.println("Input up to 10 numbers for the array: ");
 for(int i=0;i<=9;i++){
   String input = scan.nextLine();
   if(input.equals("stop")) 
       break;
   else
       array[i]=Integer.valueOf(input);
 }