public class TestPrintX {
        public static void PrintX (int number) {
         for (int i = 1; i <= (number * 2 + 1); i++)
           {
               for (int j = 0; j <= (number * 2 + 1); j++)
               {
                   if (i == j) 
                   {
                       System.out.print("*");
                   }
                   else if (i + j == (number * 2 + 2))
                   {
                       System.out.print("*");
                   }
                   else
                   {
                       System.out.print(" ");
                   }
               }
               System.out.println("");
           }
        } 
        public static void main(String arg[]) {
            PrintX(3);
        } // end of main method
} // end of class