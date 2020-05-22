import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.script.*;

class ScriptEngineCalculations {

    public static void main(String[] args) {
        final ScriptEngine engine = new ScriptEngineManager().
            getEngineByExtension( "js" );

        String[] ops = {"+", "-", "*", "/"};

        JPanel gui = new JPanel(new BorderLayout(2,2));
        JPanel labels = new JPanel(new GridLayout(0,1));
        gui.add(labels, BorderLayout.WEST);
        labels.add(new JLabel("a"));
        labels.add(new JLabel("operand"));
        labels.add(new JLabel("b"));
        labels.add(new JLabel("="));

        JPanel controls = new JPanel(new GridLayout(0,1));
        gui.add(controls, BorderLayout.CENTER);
        final JTextField a = new JTextField(10);
        controls.add(a);
        final JComboBox operand = new JComboBox(ops);
        controls.add(operand);
        final JTextField b = new JTextField(10);
        controls.add(b);
        final JTextField output = new JTextField(10);
        controls.add(output);

        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                String expression =
                    a.getText() +
                    operand.getSelectedItem() +
                    b.getText();
                try {
                    Object result = engine.eval(expression);
                    if (result==null) {
                        output.setText( "Output was 'null'" );
                    } else {
                        output.setText( result.toString() );
                    }
                } catch(ScriptException se) {
                    output.setText( se.getMessage() );
                }
            }
        };

        // do the calculation on event.
        operand.addActionListener(al);
        a.addActionListener(al);
        b.addActionListener(al);

        JOptionPane.showMessageDialog(null, gui);
    }
}