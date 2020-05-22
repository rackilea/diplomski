public class MaxOccurance {
    public static void main(String[] args) {
        int count = 0;
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt(), temp;

        if (num1 != 0 || num2 != 0) {
            for (int num = num1; num <= num2; num++) {
                temp = num;
                while (temp != 0) {
                    int i = temp % 10;
                    if (i == 4) {
                        count++;
                        // break;
                    }
                    temp = temp / 10;
                }
            }
            System.out.println(count);
        }

    }
}