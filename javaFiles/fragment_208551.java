import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class LargestApplet extends Applet implements ActionListener {

    private static final long serialVersionUID = 1L;
    int number =0;
    double highNumber=-1;
    double lowNumber=-1;



    // Create components for applet
    Label numberLabel = new Label("Enter a number:");
    TextField numberField = new TextField(5);
    Button okButton = new Button("OK");
    Button cancelButton = new Button("Cancel");
    Label highNumberOutputLabel = new Label("The Highest number is: 0         ");

    public void init() {
        add(numberLabel);
        add(numberField);
        numberField.requestFocus();

        add(okButton);
        add(cancelButton);
        add(highNumberOutputLabel);

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        okButton.setActionCommand("ok");
        cancelButton.setActionCommand("cancel");

        setSize(400, 500);  // Sets the size of the applet window
    }
    public void actionPerformed(ActionEvent e) {
        int number = 0, highNumber = -1;

        String command = e.getActionCommand();

        if(command.equals("cancel"))
            System.exit(0);

        if (numberField.getText().length() == 0) {
            numberField.requestFocus();
            JOptionPane.showMessageDialog(null,
                    "Number Cannot blank", "D A T A   E R R O R",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            number = Integer.parseInt(numberField.getText());
        } catch (NumberFormatException ex) {
            numberField.requestFocus();
            JOptionPane.showMessageDialog(null, "Number is invalid",
                    "D A T A   E R R O R", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (number < 0 || number > 10) {
            numberField.requestFocus();
            JOptionPane.showMessageDialog(null,
                    "Number must be between 0 and 10",
                    "D A T A   E R R O R", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Determine highest number
        Integer [] numberAr = {number};
        for(int i = 0; i < numberAr.length; i++)
        {
            number += numberAr[i];
            if (numberAr[i] < lowNumber)
                lowNumber = numberAr[i];
            else if (numberAr[i] > highNumber)
                highNumber = numberAr[i];
        }

        // Display the results
        highNumberOutputLabel.setText("The Highest Number is:   "
                + (highNumber));
    }
}