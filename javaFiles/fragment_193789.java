public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean end = false;
    long value;
    while (end == false) {
        try {
            value = input.nextLong();
            end = true;
        } catch (InputMismatchException e) {
            System.out.println("Please input the right LONG value!");
            input.nextLine();
        }
    }
}