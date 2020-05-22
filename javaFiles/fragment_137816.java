import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example1 {
    private String operator;

    private class equalsButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           System.out.println("=");
           InfixToPostfixParens.convert(operator);
        }
    }
}

public class InfixToPostfixParens {
    public static void convert(String s) {
      // Do something useful
    }
}