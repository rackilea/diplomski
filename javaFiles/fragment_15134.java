import javax.swing.JOptionPane;

public class Quiz {

    public static void main(String[] args) 
    {


    int x = 0;
    String[] quizQuestion = {"What is the color of the sky?", "What is the       color of the sea?", "What is the color of the earth?"};
    int score = 0;
    String correct = "You are correct";
    String incorrect = "You are incorrect";
    String playerAnswerString = " ";
    playerAnswerString.toUpperCase();
    char playerAnswer = playerAnswerString.charAt(0);

    JOptionPane.showMessageDialog(null, "Test Your Knowledge!");
    JOptionPane.showMessageDialog(null, "Select an answer to the questions.");
    for(x = 0; x < 3; x++)
    {


        JOptionPane.showMessageDialog(null, quizQuestion[x]);
        if(x==0)
        {
            playerAnswerString = JOptionPane.showInputDialog(null, "A = Blue, B = Green, C = Brown");

            System.out.println(playerAnswerString+"   "+playerAnswer);

            if(playerAnswerString.equals("A"))
            {
                JOptionPane.showMessageDialog(null, correct);
                score++;
            }
            else
            {
                JOptionPane.showMessageDialog(null, incorrect);
            }
        }
        if(x==1)
        {
            playerAnswerString = JOptionPane.showInputDialog(null, "A = Blue, B = Green, C = Brown");
            if(playerAnswerString.equals("B"))
            {
                JOptionPane.showMessageDialog(null, correct);
                score++;
            }
            else
            {
                JOptionPane.showMessageDialog(null, incorrect);
            }
        }
        if(x==2)
        {
            playerAnswerString = JOptionPane.showInputDialog(null, "A = Blue, B = Green, C = Brown");
            if(playerAnswerString.equals("C"))
            {
                JOptionPane.showMessageDialog(null, correct);
                score++;
            }
            else
            {
                JOptionPane.showMessageDialog(null, incorrect);
            }
        }
    }
    JOptionPane.showMessageDialog(null, "You scored " + score + "/3.");


}
}