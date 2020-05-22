import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Calculator implements Initializable {

    double data = 0d;
    int operation = -1;
    private boolean start = false;

    @FXML
    private Label display;

    @FXML
    private Button two;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button three;

    @FXML
    private Button one;

    @FXML
    private Button six;

    @FXML
    private Button seven;

    @FXML
    private Button multi;

    @FXML
    private Button add;

    @FXML
    private Button divide;

    @FXML
    private Button minus;

    @FXML
    private Button equals;

    @FXML
    private Button clear;

    @FXML
    private Button zero;

    @FXML
    private Button nine;

    @FXML
    private Button eight;

    @FXML
    void handleButtonAction(ActionEvent event) {

//        if(start)
//        {
//            display.setText("");
//            start = false;
//        }

        if(event.getSource() == one)
        {
            display.setText(display.getText() + "1");
        }
        else if(event.getSource() == two)
        {
            display.setText(display.getText() + "2");
        }
        else if(event.getSource() == three)
        {
            display.setText(display.getText() + "3");
        }
        else if(event.getSource() == four)
        {
            display.setText(display.getText() + "4");
        }
        else if(event.getSource() == five)
        {
            display.setText(display.getText() + "5");
        }
        else if(event.getSource() == six)
        {
            display.setText(display.getText() + "6");
        }
        else if(event.getSource() == seven)
        {
            display.setText(display.getText() + "7");
        }
        else if(event.getSource() == eight)
        {
            display.setText(display.getText() + "8");
        }
        else if(event.getSource() == nine)
        {
            display.setText(display.getText() + "9");
        }
        else if(event.getSource() == zero)
        {
            display.setText(display.getText() + "0");
        }
        else if(event.getSource() == clear)
        {
            display.setText("");
        }
        else if(event.getSource() == add)
        {
            data = Float.parseFloat(display.getText());
            operation = 1;
            display.setText("");
        }
        else if(event.getSource() == minus)
        {
            data = Float.parseFloat(display.getText());
            operation = 2;
            display.setText("");
        }
        else if(event.getSource() == multi)
        {
            data = Float.parseFloat(display.getText());
            operation = 3;
            display.setText("");
        }
        else if(event.getSource() == divide)
        {
            data = Float.parseFloat(display.getText());
            operation = 4;
            display.setText("");
        }
        else if(event.getSource() == equals)
        {
            Float secondOperand = Float.parseFloat(display.getText());
            switch(operation)
            {
                case 1: //Addition
                    Double ans = data + secondOperand;
                    display.setText(String.valueOf(ans));
                    //data = ans;
                    break;
                case 2: //Subtraction
                    ans = data - secondOperand;
                    display.setText(String.valueOf(ans));
                    //data = ans;
                    break;
                case 3: //Multiplication
                    ans = data * secondOperand;
                    display.setText(String.valueOf(ans));
                    //data = ans;
                    break;
                case 4: //Division
                    ans = 0d;
                    try{
                        ans = data / secondOperand;
                    }catch(Exception ex){display.setText("Error");}
                    display.setText(String.valueOf(ans));
                    //data = ans;
                    break;
            }
//            if(event.getSource() != divide && event.getSource() != add && event.getSource() != multi && event.getSource() != minus)
//            {
//                start = true;
//            }
        }
    }

    @FXML
    private void send2sceneconver(ActionEvent event) throws Exception{
        Parent rootBMI = FXMLLoader.load(getClass().getResource("ConversionCal.fxml"));

        Scene scene2 = new Scene(rootBMI);
        Stage calS = (Stage) ((Node) event.getSource()).getScene().getWindow();

        calS.setScene(scene2);
        calS.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}