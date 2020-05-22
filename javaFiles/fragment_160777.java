public static final void fibonacci() {
    int num = 0;
    int num2 = 1;
    int tnum = 0;
    int startnum = 1;
    System.out.println("Please input a number:"); 
    Scanner input = new Scanner(System.in); 
    int x = input.nextInt();
    for (int i = 0; i < x; i++) {
        System.out.print(num);
        tnum = num + num2;
        num = num2;
        num2 = tnum;
    }
}