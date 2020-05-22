package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Converter extends JFrame {

    private static final long serialVersionUID = 7049836604855145085L;

    private DefaultComboBoxModel<String> inputModel;
    private DefaultComboBoxModel<String> outputModel;

    private JButton submitButton;

    private JComboBox<String> inputComboBox;
    private JComboBox<String> outputComboBox;
    private JComboBox<String> typeComboBox;

    private JTextField inputDimensionField;
    private JTextField outputDimensionField;

    private List<ConversionFactor> conversionFactors;

    public Converter() {
        this.conversionFactors = createConversionFactors();

        setTitle("ComboBoxTest");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        add(createConversionPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
        pack();
    }

    private JPanel createConversionPanel() {
        JPanel panel = new JPanel();

        String types[] = { "Choose one", "Distance", "Weight" };
        typeComboBox = new JComboBox<String>(types);
        typeComboBox.setSelectedIndex(0);
        typeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    if (event.getItem().equals("Distance")) {
                        changeToDistance();
                    } else if (event.getItem().equals("Weight")) {
                        changeToWeight();
                    }
                }
            }
        });
        panel.add(typeComboBox);

        inputDimensionField = new JTextField(10);
        panel.add(inputDimensionField);

        String measurements[] = { "Choose one" };
        inputComboBox = new JComboBox<String>(measurements);
        panel.add(inputComboBox);

        JLabel label = new JLabel("converts to");
        panel.add(label);

        outputDimensionField = new JTextField(10);
        panel.add(outputDimensionField);

        outputComboBox = new JComboBox<String>(measurements);
        panel.add(outputComboBox);

        return panel;
    }

    private void changeToDistance() {
        String measurementsd[] = { "Choose one", "Meters", "Feet", "Inches",
                "Miles", "Yards" };
        inputModel = new DefaultComboBoxModel<String>(measurementsd);
        outputModel = new DefaultComboBoxModel<String>(measurementsd);
        inputComboBox.setModel(inputModel);
        outputComboBox.setModel(outputModel);
    }

    private void changeToWeight() {
        String measurementsw[] = { "Choose one", "Pounds", "Kilograms", "Grams" };
        inputModel = new DefaultComboBoxModel<String>(measurementsw);
        outputModel = new DefaultComboBoxModel<String>(measurementsw);
        inputComboBox.setModel(inputModel);
        outputComboBox.setModel(outputModel);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        submitButton = new JButton("Convert");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                double input = Double.parseDouble(inputDimensionField.getText());
                String inputValue = (String) inputComboBox.getSelectedItem();
                String outputValue = (String) outputComboBox.getSelectedItem();
                double output = input
                        * getConversionFactor(inputValue, outputValue);
                String s = String.format("%.2f", output);
                outputDimensionField.setText(s);
            }
        });
        panel.add(submitButton);

        return panel;
    }

    private double getConversionFactor(String inputValue, String outputValue) {
        for (ConversionFactor factor : conversionFactors) {
            if (inputValue.equalsIgnoreCase(factor.getInputUnit())
                    && outputValue.equalsIgnoreCase(factor.getOutputUnit())) {
                return factor.getConversionFactor();
            }
        }
        return 1.0D;
    }

    private List<ConversionFactor> createConversionFactors() {
        List<ConversionFactor> conversionFactors = new ArrayList<ConversionFactor>();
        ConversionFactor factor = new ConversionFactor("meters", "feet",
                3.2808D);
        conversionFactors.add(factor);
        factor = new ConversionFactor("meters", "inches", 39.370D);
        conversionFactors.add(factor);

        // I'll leave the rest for you to fill out.

        return conversionFactors;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Converter();
                frame.setVisible(true);
            }
        });
    }

    public class ConversionFactor {

        private final String inputUnit;
        private final String outputUnit;

        private final double conversionFactor;

        public ConversionFactor(String inputUnit, String outputUnit,
                double conversionFactor) {
            this.inputUnit = inputUnit;
            this.outputUnit = outputUnit;
            this.conversionFactor = conversionFactor;
        }

        public String getInputUnit() {
            return inputUnit;
        }

        public String getOutputUnit() {
            return outputUnit;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }

    }

}