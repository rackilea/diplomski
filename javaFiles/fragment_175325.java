//declared variables here. global variables must be declared static when accessed in a static method (ex: user_input())
static int y_;
static int m_;
static int b_;
static int x_;

public static void main(String[] args) {
    // Creates scanner for input of menu Def as menu selector
    Scanner user_Selection = new Scanner(System.in);

    System.out.println("Enter 1 if you would like to solve for Y?");
    System.out.println("Enter 2 if you would like to solve for M?");
    System.out.println("Enter 3 if you would like to solve for B?");
    System.out.println("Enter 4 to Quit");

    //Converts user input to an integer
    int selection = user_Selection.nextInt();

    //call user_input()
    user_input(selection);


}

public static void user_input(int selection) {

    Scanner user_Selection = new Scanner(System.in);
    int userAnswer;
    int y_intercept = (int) (Math.floor(Math.random() * 201) - 100);
    int slope = (int) Math.floor(Math.random() * 201) - 100;
    int point_of_line_cross = (int) Math.floor(Math.random() * 201) - 100;
    int independent_variable = (int) Math.floor(Math.random() * 201) - 100;

    y_ = point_of_line_cross;
    m_ = slope;
    b_ = y_intercept;
    x_ = independent_variable;


    //Tests what user input was, with expected output
    if (selection == (1)) {
        System.out.println("You chose to solve for Y: ");
        System.out.println("Y = " + slope + "(" + independent_variable + ")" + " + " + y_intercept);
        System.out.println("Input your answer: ");
        userAnswer = user_Selection.nextInt();
        /*After user enters answer we test the answer by calling test_input
         * */
       test_input(userAnswer);
    } else if (selection == (2)) {
        System.out.println("You chose to solve for M: ");
        System.out.println("M = " + "(" + point_of_line_cross + " - " + y_intercept + ")" + " / " + independent_variable);
        System.out.println("Input your answer: ");
        userAnswer = user_Selection.nextInt();
        /*After user enters answer we test the answer by calling test_input
         * */
        test_input(userAnswer);
    } else if (selection == (3)) {
        System.out.println("You chose to solve for B: ");
        System.out.println("B = " + point_of_line_cross + " - " + slope + "(" + independent_variable + ")");
        System.out.println("Input your answer: ");
        userAnswer = user_Selection.nextInt();
        /*After user enters answer we test the answer by calling test_input
         * */
        test_input(userAnswer);
    } else if (selection == (4)) {
        System.out.println("You chose to quit the program. ");
    }
}

// you forgot to include return type ex: void, int, String, double, float, etc
public static void test_input(int entered_answer) {
    //Solves the problem in order to compare to User input
    int answer_y = ((m_) * (x_)) + (b_);
    int answer_m = (y_) - ((b_) / (x_));
    int answer_b = (y_) - ((m_) * (x_));

    //Problem solver defined
    int answer = entered_answer;

    //Creates loop for program
    int counter = 0;
    int correct = 0;
    boolean answers_correct = false;

    while (!answers_correct && correct < 3) {
        if (answer == answer_y) {
            counter++;
            correct++;
            System.out.println("You answered correctly");
            return;
        } else if (counter >= 3 && correct < 3) {
            System.out.println("You've been missing the questions lately, let me help! ");
        } else {
            System.out.println("Try again");
            counter++;
            correct = 0;
            break;
        }
    }

}