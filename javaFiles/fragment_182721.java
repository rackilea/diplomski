int size = 11; 
    for(int i = 0; i < size-1; i++) {
        for(int j = 0; j < size - (i+1); j++)
            System.out.print(" ");
        System.out.print("*");
        for(int k = 0; k < 2*i - 1; k++)
            System.out.print(" ");
        if(i > 0)
            System.out.print("*\n");
        else
            System.out.println();
    }
    for(int i = 0; i < size; i++)
        System.out.print("* ");