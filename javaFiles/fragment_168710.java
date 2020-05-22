import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class TurkisliraFormatterDemo extends JPanel
                implements PropertyChangeListener {

    private double amount = 100000;
    private JFormattedTextField amountField;

    private NumberFormat amountDisplayFormat;
    private NumberFormat amountEditFormat;

    public TurkisliraFormatterDemo() {
        super(new BorderLayout());
        setUpFormats();

        amountField = new JFormattedTextField(
                        new DefaultFormatterFactory(
                                        new NumberFormatter(amountDisplayFormat),
                                        new NumberFormatter(amountDisplayFormat),
                                        new NumberFormatter(amountEditFormat)));
        amountField.setValue(new Double(amount));
        amountField.setColumns(10);
        amountField.addPropertyChangeListener("value", this);

        JPanel fieldPane = new JPanel(new GridLayout(0, 1));
        fieldPane.add(amountField);

        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(fieldPane, BorderLayout.LINE_END);
        add(new JButton("Hello"), BorderLayout.SOUTH);
    }

    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == amountField) {
            amount = ((Number) amountField.getValue()).doubleValue();
            System.out.println("amount = " + amount);
//            amountField.setValue(amount);
        }

    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("FormatDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new TurkisliraFormatterDemo());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("windows", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

    private void setUpFormats() {
        amountDisplayFormat = NumberFormat.getCurrencyInstance(new Locale("tr", "TR"));
        System.out.println(amountDisplayFormat.format(1200));
        amountDisplayFormat.setMinimumFractionDigits(0);
        amountEditFormat = NumberFormat.getNumberInstance();

    }
}