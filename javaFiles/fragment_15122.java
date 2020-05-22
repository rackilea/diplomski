public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter a number 1...9 :");

    int num = scan.nextInt(); 
    scan.close();

    for (int i = 1; i <= num; i++) { 
        for (int j = 2*(num-i); j > 0; j--)
            if (num > 1)
                System.out.print(" ");
        for (int j = i; j >= 1; j--) {
            if (j != i)
                System.out.print(" ");
            System.out.print(j); 
        }
        System.out.println();
    }
}