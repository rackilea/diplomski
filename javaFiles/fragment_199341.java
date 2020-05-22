Scanner game = new Scanner(System.in);

double num = 0;
double sum = 0;
int cnt = 0;

while (true) {
    System.out.println("Enter as many non-negative integers as you like ");
    System.out.println("one at a time and I will find the average");
    System.out.println("Enter done to stop entering numbers");

    double lowscore = Double.MAX_VALUE;
    double highscore = 0;

    System.out.print("enter number: ");
    String ans = game.next();
    while (!ans.equals("done")) {

        num = Double.parseDouble(ans);

        lowscore = Math.min(lowscore, num);
        highscore = Math.max(highscore, num);

        sum += num;
        cnt++;

        System.out.print("enter number: ");
        if (num > highscore) {
            highscore = num;
        }
        if (num < lowscore) {
            lowscore = num;
        }
        ans = game.next();
    }

    sum -= lowscore;
    sum -= highscore;

    System.out.println("Throwing out low score " + lowscore + " and high score " + highscore);
    System.out.println("Total Score " + sum + " count scores " + cnt + " avg score " + sum / cnt);

    System.out.println("Enter another contestant (Y/N)?");
    String str = game.next();
    if (!str.equalsIgnoreCase("Y")) {
        break;
    }
}