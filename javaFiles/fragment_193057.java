public class A {

    public void extractBoundaries(int a[][],int rows,int cols){


        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < cols; j++) { 
                if (i == 0 || j == 0 || i == 3 || j == 3) 
                    System.out.print(a[i][j] + " "); 

                else
                    System.out.print("  "); 
            } 
            System.out.println(""); 
        }
        System.out.println("");
   }
    public void cropCenterPart(int a[][],int rows,int cols){

        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < cols; j++) { 
                if (i == 0 || j == 0 || i == 3 || j == 3) 
                  System.out.print("  ");
                else

                    System.out.print(a[i][j] + " ");
            } 
            System.out.println(""); 
        }
        System.out.println("");


    }
}