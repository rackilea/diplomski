public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    double sum = 0;
    double count = 0;

    while(input.hasNextInt()) {
        int num = input.nextInt();

        if (num == 0) {
            break;
        }
        else if (num > 4) {
            System.out.println("Invalid number");
        }
        else {
            sum += num;
            count += 1;
        }
    }

    System.out.println("Average: " + sum/count);
}