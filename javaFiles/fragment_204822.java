int x = 0;
    System.out.print("Enter: ");
    x = var.nextInt();
    for(int a = 1; a <= x; a++){
        for(int c = 0; c < a; c++){
            System.out.print("*");
        }
        System.out.println();
    }
    for (int a = x - 1; a > 0; a--){
        for(int c = a; c > 0; c--)
            System.out.print("*");
         System.out.print(""\n");
    }