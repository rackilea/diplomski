// third triangle
for(row=0; row < 10; row++)
        {
            for(column=0; column < row; column++){
                System.out.print(" ");
            }
            for(column=0; column < 10-row; column++){
                System.out.print("*");
            }
            System.out.println();
        }