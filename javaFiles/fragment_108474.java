public static void main(String[] args) {
    Ordinals number = new Ordinals();
    Scanner input = new Scanner(System.in);
    while(true){
        System.out.println("Enter an integer between 0 to 10: ");
        int i = input.nextInt();
        System.out.println(i+number.Ordinals(i));
    }
}