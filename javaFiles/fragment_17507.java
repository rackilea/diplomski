public static void main(String[] args) {
    int height = 9, width = 9;
    int spaces = (width - 1) / 2, asterisks = 1;



    for(int i = 0;((i*2)) < height; i++){
        for(int ii = 0;ii < spaces;ii++){
           System.out.print(" ");  
        }
        for(int ii = 0;ii < asterisks;ii++){
           System.out.print("*");
        }
    spaces--;
    if(asterisks < width)asterisks += 2;
    System.out.println();
    }

    spaces = 0;

    for(int i = 0; ((i*2)+1) < height; i++){
        if(width < height){
            for(int ii = 0;ii < spaces;ii++){
                System.out.print(" ");
            }
            for(int ii = 0;ii < asterisks;ii++){
               System.out.print("*");
            }
        }else{
            for(int ii = 0;ii < (spaces + 1);ii++){
                System.out.print(" ");
            }
            for(int ii = 0;ii < (asterisks - 2);ii++){
               System.out.print("*");
            }
        }
    spaces++;
    asterisks -= 2;
    System.out.println();
    }
}