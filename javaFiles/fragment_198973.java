public static void main(String[] args)
{
   Scanner sc = new Scanner(System.in);

   String[] input= new String[4];

   String[] output= new String[4];

   // -
   System.out.println("Enter a String");
   String inputStr = sc.next();

   for (int i = 0, n = 0; i < 4; i++, n+=4) {
       input[i] = inputStr.substring(0+n, 4+n);
   }
   // -

   output[0] = input[0];
   for(int i=1; i<4; i++)
   {
       output[i] = Shift(input[i],i);
   }

   for(int i=0; i<4; i++)
   {
       System.out.println(output[i]);
   }

}