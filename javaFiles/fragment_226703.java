public class A {

    public static void main(String[] args) {

        int height = Integer.parseInt(args[0]);
        int counter = 1;
        int spaces = height-1;
        for (int row = 1; row <= height; row++){

           for (int j = 1; j <= spaces; j++){
              System.out.print(" ");
           }

           for (int j = 1; j <= counter; j++){
              System.out.print("*");
           }

           System.out.println("");
           counter += 2;
           spaces--;
         } // end of outer loop
         counter-=2; // length of last line
         for(int i=1; i<=counter/2-1; i++){
            System.out.print(" ");
          }
          System.out.print("===");
    }
}