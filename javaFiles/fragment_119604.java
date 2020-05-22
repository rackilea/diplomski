public static void main(String[] args) {
    int i = 0;
    double yes = 0.01;

    while(i < 100) {
        System.out.println("i = " + i);
        System.out.println("Do you want to add 1? if yes type in '0.01' ");

        Scanner keyboardInput = new Scanner(System.in);
        double add = keyboardInput.nextDouble();

        if (yes == add) {
            i++;
            System.out.println("i now is: " + i);
        }
    }
}