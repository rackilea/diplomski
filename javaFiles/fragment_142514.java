Scanner keyboard = new Scanner(System.in);
int Maxgrade = 0, Mingrade = 0, InputTimes = 0, grade = 0, totalgradeNoF = 0;
boolean GameOver = false;
String input = "";
do {
    System.out.println("Please go on : ('y' to stop)");
    input = keyboard.nextLine();
    if (input.equals("y")) {
        GameOver = true;
    } else {
        grade = Integer.parseInt(input);
        InputTimes++;

        if (grade > Maxgrade) {
             Maxgrade = grade;
        }
        if (Mingrade > grade) {
             Mingrade = grade;
        }

        totalgradeNoF = grade + totalgradeNoF;
   }
} while (!GameOver);