public class SO {
public static void main(String[] args) throws ClassNotFoundException{
    getinfo();//Set the random question and answer

    Object[] options = {"Yes, please", "No way!"};
    int n = JOptionPane.showOptionDialog(null,
            SO.question,//Reference the question set
            "",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[0]); //default button title

    JOptionPane.showMessageDialog(null, SO.answer);
}

public static void getinfo(){ //Will set question and answer
    int category = new Random().nextInt(2 - 0);//Random number to get a category
    int choice = new Random().nextInt(2 - 0);//Random to get a selection

    SO.question = questions[category][choice];//Get question
    SO.answer = answers[category][choice];//Answer is located in same position in answers array
}

/*Each category is represented by a seperate array within the questions
 * 2 dimensional array.  These are declared as static fields or 'Global fields'
 * This way they are easily accessible and only initialised once
 */
private static String[][] questions = new String[][]{ 
    {"Question 1, category 1", "Question 2 category 1"},//questions[0][*] for one category 
    {"Question 1 category 2", "Question 2 category 2"}//questions[1][*] on another category
};

/*The answers array mirrors the other array so each answer in this 2D array 
 * is in the same position as the relevant question in the questions array
 * 
 */
private static String[][] answers = new String[][]{ 
    {"Answer 1 category 1", "Answer 2 category 1"}, //answers[0][*] for questions [0][*]  
    {"Answer 1 category 2", "Answer 2 category 2"}//answers[1][*] for questions [1][*]
};

//These will each hold a question and an answer
private static String question;
private static String answer;