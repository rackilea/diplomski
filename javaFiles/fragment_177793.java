int a = -1;
    do{
        System.out.println("Enter a number between 0 an 10");
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
    }while (a>0 && a<10);