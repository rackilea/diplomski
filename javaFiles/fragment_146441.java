public static int getValue(int[] num) {
    Scanner kb = new Scanner(System.in);
    int userNumber;
    System.out.print("Enter a number between 0 and 49: ");
    userNumber = kb.nextInt();

    return userNumber;
}

public static void main(String[] args) {

    int[] num = new int[30];
    int randomNumber;

    Random r = new Random();

    for (int x = 0; x < num.length; x++) {
        randomNumber = r.nextInt(50);
        num[x] = randomNumber;
        System.out.println(num[x] + randomNumber);
    }
    int userNumber = getValue(num);
    System.out.println(userNumber);

    System.out.println("Numbers higher than user's number include: ");
    for (int x = 0; x < num.length; x++) {
        if (num[x] > userNumber) {
            System.out.println(num[x]);
        }
    }
    System.out.println("Numbers less than user's number include: ");
    for (int x = 0; x < num.length; x++) {
        if (num[x] < userNumber) {
            System.out.println(num[x]);
        }
    }
}