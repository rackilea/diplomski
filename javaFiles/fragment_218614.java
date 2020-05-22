public void show() 
{
    switch (color & 4){
        case 4:
            System.out.print("red ");
        default:
            switch (color & 2){
                case 2:
                    System.out.print("green ");
                default:
                    switch (color & 1){
                        case 1:
                            System.out.print("blue");
                    }
            }
    }
    System.out.println();
}