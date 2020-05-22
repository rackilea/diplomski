import javax.swing.JFrame;
import java.util.Arrays;

public class Demo
{
    public static void makeUI()
    {
        JFrame frame = new JFrame("Your frame");
        /**
         * Put data to your filtered combobox.
         */
        FilterComboBox fcb = new FilterComboBox(
                Arrays.asList(
                    "",
                    "English", 
                    "French", 
                    "Spanish", 
                    "Japanese",
                    "Chinese",
                    "American English",
                    "Canada French"
                    ));
        /**
         * Set up the frame.
         */
        frame.getContentPane().add(fcb);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception
    {
        makeUI();
    }
}