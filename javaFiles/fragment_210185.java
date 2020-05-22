import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JSpinner subTotal;
        private JSpinner custom;
        private JButton btnCalculate;

        private TipModel model;

        private JLabel tipAmountLabel;
        private JLabel billTotalLabel;

        public TestPane() {
            setBorder(new EmptyBorder(10, 10, 10, 10));
            subTotal = new JSpinner(new SpinnerNumberModel());
            subTotal.setValue(0d);
            subTotal.setEditor(new JSpinner.NumberEditor(subTotal, "$#0.0#"));

            model = new TipModel();

            custom = new JSpinner(new SpinnerNumberModel(0, 0, 1, 0.05));
            custom.setEditor(new JSpinner.NumberEditor(custom, "##%"));

            JCheckBox cb15 = new JCheckBox(new TipAction(model, 0.15d));
            JCheckBox cb20 = new JCheckBox(new TipAction(model, 0.20d));
            JCheckBox cbCustom = new JCheckBox(new CustomTipAction(model, custom));

            ButtonGroup bg = new ButtonGroup();
            bg.add(cb15);
            bg.add(cb20);
            bg.add(cbCustom);

            btnCalculate = new JButton("Calculate Tip");
            btnCalculate.setMargin(new Insets(10, 10, 10, 10));

            tipAmountLabel = new JLabel("...");
            billTotalLabel = new JLabel("...");
            billTotalLabel.setHorizontalAlignment(JLabel.CENTER);
            tipAmountLabel.setHorizontalAlignment(JLabel.CENTER);

            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(2, 2, 2, 2);
            add(subTotal, gbc);

            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            add(cb15, gbc);
            gbc.gridy++;
            add(cb20, gbc);
            gbc.gridwidth = 1;
            gbc.gridy++;
            add(cbCustom, gbc);

            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(custom, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(btnCalculate, gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridy++;
            add(tipAmountLabel, gbc);
            gbc.gridy++;
            add(billTotalLabel, gbc);

            btnCalculate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double tipPercentage = model.getTipPercentage();

                    if (tipPercentage > 0.0) {

                        double subTotalAmount = (double) subTotal.getValue();
                        double tipAmount = subTotalAmount * tipPercentage;
                        double billTotal = subTotalAmount + tipAmount;

                        tipAmountLabel.setText("Tip amount: " + NumberFormat.getCurrencyInstance().format(tipAmount));
                        billTotalLabel.setText("Bill total: " + NumberFormat.getCurrencyInstance().format(billTotal));

                    } else {
                        JOptionPane.showMessageDialog(TestPane.this, "Please provide a valid tip percentage");
                    }
                }
            });
        }

        public class TipModel {

            private double tipPercentage;

            public double getTipPercentage() {
                return tipPercentage;
            }

            public void setTipPercentage(double tipPercentage) {
                this.tipPercentage = tipPercentage;
            }

        }

        public class TipAction extends AbstractAction {

            private TipModel model;
            private double tipPercentage;

            public TipAction(TipModel model, double tipPercentage) {
                this.model = model;
                this.tipPercentage = tipPercentage;
                putValue(NAME, NumberFormat.getPercentInstance().format(tipPercentage));
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                model.setTipPercentage(tipPercentage);
            }

        }

        public class CustomTipAction extends AbstractAction {

            private TipModel model;
            private JSpinner spinner;

            public CustomTipAction(TipModel model, JSpinner spinner) {
                this.model = model;
                this.spinner = spinner;

                spinner.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        model.setTipPercentage((double) spinner.getValue());
                    }
                });
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                model.setTipPercentage((double) spinner.getValue());
            }

        }

    }

}