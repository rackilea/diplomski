public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean end = false;
    long value;

    while (end == false)  {
        if (input.hasNextLong()) {
            value = input.nextLong();
            end = true;
        } else {
            System.out.println("input the LONG value!");
            input.nextLine();
        }
    }
}