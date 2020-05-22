public static int getSize()
{
     Scanner kbd = new Scanner(System.in);
     int x = 1;
     while(x==1){
         System.out.println("Enter the size (>0): ");
         int n = kbd.nextInt();
         if (n>0){
            x--;
            return n;
         }
     }

      return 0; // Add this line
}