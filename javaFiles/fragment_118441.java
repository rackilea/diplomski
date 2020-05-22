public static void main(String[] args) {
        int inputAnswer;
        int pickedNumber1;
        int pickedNumber2;
        int answer;
        Random randNum1 = new Random();
        while (true) {

            pickedNumber1 = 1 + randNum1.nextInt(12);
            pickedNumber2 = 1 + randNum1.nextInt(12);

            System.out.println("What is " + pickedNumber1 + " multiplied by "
                    + pickedNumber2 + "?");

            answer = (pickedNumber1 * pickedNumber2);

            Scanner myScanner = new Scanner(System.in);
            inputAnswer = -1;
            while (inputAnswer < 0) {
                try
                {
                    System.out.println("Please enter a valid number:");
                    inputAnswer = myScanner.nextInt();
                }catch(Exception e)
                {
                    myScanner.nextLine();
                }
            }

            if (inputAnswer == answer) {
                System.out.println("Well done!");
            } else {
                System.out.println("Please Try Again");
            }
        }
}