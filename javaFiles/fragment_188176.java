import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

/*The controller process the user requests.
 * It listeners that are called when the View detects a user interaction.
 * Based on the user action, the Controller calls methods in the View and Model
 * to accomplish the requested action.
 */
class MVC_Controller{

    private MVC_Model model;
    private MVC_View view;

    MVC_Controller(MVC_View view,MVC_Model model) {
      this.model=model;
      this.view=view;
      //observe view buttons
      view.getConfirmationButton().addActionListener(e -> confirmationButtonPressed());
      view.getNextButton().addActionListener(e -> setNewQuestion());
      setNewQuestion(); //initialize view with a question
      view.setVisible();
    }
    //respond to confirmation button click
    private void confirmationButtonPressed() {
        model.setAnswer(view.getAnswer());
        if(model.isCorrectAnswer()) {
            view.setInfo("Well done !");
        }else {
            view.setInfo("Wrong answer !");
        }
    }
    //respond to next button click
    private void setNewQuestion() {
        view.clear();
        model.newQuestion();
        view.setInfo("Select button ");
        view.updateFromModel();
    }

    /*In practice you would probably want to have this in a
     * Separate Main class
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MVC_Model model = new MVC_Model();
                MVC_View  view  = new MVC_View(model);
                new MVC_Controller(view, model);
            }
        });
    }
}

/*Model contains the information for the view and information from the view
 * as well as the logic.
 * The model is independent of the user interface.
 */
class MVC_Model {

    private int question,answer = 0;
    private Random rnd = new Random();

    MVC_Model() {
        newQuestion();
    }

    //set question to 1 or 2.
    void newQuestion() {
        question = (rnd.nextInt(99) > 49)  ? 2 : 1 ;
        answer = 0;
    }

    int getQuestion() { return question;}
    int getAnswer()   { return answer;  }
    void setQuestion(int question) { this.question = question; }
    void setAnswer(int answer)     { this.answer = answer;     }
    boolean isCorrectAnswer()    { return question == answer;  }
}

/*View only contains the user interface part*/
class MVC_View {

    private MVC_Model model;
    private JTextField question = new JTextField(2);
    private JToggleButton button1 = new JToggleButton("1"); //on - off toggle buttons
    private JToggleButton button2 = new JToggleButton("2");
    private JButton confirm = new JButton("Confirm");
    private JButton next = new JButton("Next");
    private JLabel info = new JLabel();
    private JFrame frame;

    MVC_View(MVC_Model model){
        this.model = model;

        ButtonGroup bGroup = new ButtonGroup();   //add buttons to group so
        bGroup.add(button1);bGroup.add(button2);  //only one can be selected

        JPanel topPanel = new JPanel(); //uses FlowLayout by default. Do not use null layouts
        //add components to top panel
        topPanel.add(new Label("Question: ")); //add a label to indicate question
        topPanel.add(question); topPanel.add(button1);  topPanel.add(button2);
        topPanel.add(confirm); topPanel.add(next);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0)); //set layout manager to left align
        bottomPanel.add(new Label("Information: ")); //add a label to indicate information
        bottomPanel.add(info);
        frame = new JFrame("MVC Model Demo");
        frame.add(topPanel, BorderLayout.NORTH); //uses BorderLayout by default
        frame.add(bottomPanel, BorderLayout.SOUTH); //uses BorderLayout by default
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    void setInfo(String text)       { info.setText(text); }
    JButton getConfirmationButton() { return confirm; }
    JButton getNextButton()         { return next; }
    int getAnswer() {
        if(button1.isSelected()) {
            return 1;
        }else if (button2.isSelected()){
            return 2;
        }
        return 0; //no button is selected
    }
    //rest all gui
    void clear() {
        button1.setSelected(false);
        button2.setSelected(false);
        question.setText("");
        info.setText("");
    }

    //update view from model
    void updateFromModel() {
        question.setText(String.valueOf(model.getQuestion()));
    }

    void setVisible() { frame.setVisible(true); }
}