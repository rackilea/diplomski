int x = 0;
    System.out.print("Enter: ");
    x = var.nextInt();
    for(int a = 1; a <= x; a++){
        for(int b = 0; b <= x - a; b++){
            System.out.print("");     //this code block do nothing in ur case
        }
        for(int c = 0; c < a; c++){
            System.out.print("*");
        }
    System.out.println();
    }
}