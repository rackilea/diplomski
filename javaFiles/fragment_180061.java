import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private Label questionLabel;
    @FXML
    private RadioButton answer_btn1;
    @FXML
    private RadioButton answer_btn2;
    @FXML
    private RadioButton answer_btn3;
    @FXML
    private RadioButton answer_btn4;
    @FXML
    private Button nextBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        List<String> questions = new ArrayList();

        questions.add("pytanie1");
        questions.add("pytanie2");
        questions.add("pytanie3");
        questions.add("pytanie4");
        questions.add("pytanie5");
        questions.add("pytanie6");
        questions.add("pytanie7");
        questions.add("pytanie8");
        questions.add("pytanie9");
        questions.add("pytanie10");

        String[][] answers = new String[1][4];
        answers[0][0] = "a) odp";
        answers[0][1] = "b) odp";
        answers[0][2] = "c) odp";
        answers[0][3] = "d) odp";

        questionLabel.setText("");

        questionLabel.setText(questionLabel.getText() + answers[0][0]);
        answer_btn1.setText("aaa");
    }

}