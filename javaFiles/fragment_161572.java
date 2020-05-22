import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

public class Test extends JFrame
{
  JFormattedTextField salaryFormattedTextField;
  NumberFormat numberFormat;
  NumberFormatter numberFormatter;

  public Test()
  {
    numberFormat = NumberFormat.getInstance();
    // delete line if you want to see commas or periods grouping numbers based on your locale
    numberFormat.setGroupingUsed(false);           

    numberFormatter = new NumberFormatter(format);
    numberFormatter.setValueClass(Integer.class);
    // delete line if you want to allow user to enter characters outside the value class.
    // Deleting the line would allow the user to type alpha characters, for example.
    // This pretty much defeats the purpose of formatting
    numberFormatter.setAllowsInvalid(false);

    salaryFormattedTextField = new JFormattedTextField(formatter);

    this.add(salaryFormattedTextField);
  }

  public static void main(String[] args)
  {
    Test test = new Test();
    s.pack();
    s.setVisible(true);
  }
}