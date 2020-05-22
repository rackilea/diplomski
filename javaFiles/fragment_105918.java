Scanner sc = new Scanner(System.in);
System.out.print("Enter a number between 1 and 20: ");
int value = sc.nextInt();
System.out.println("Pattern B: ");
for(int x = 1; x <= value; x++){
    for(int c = value-x; c<value; c++){
        System.out.print(" ");
    }
    for(int y = value; y>=x; y-- ){
        System.out.print("*");
    }
    System.out.print("\n");
}