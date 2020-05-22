public class SimpleInputMask {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MaskFormatteExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("input: ");
        panel.add(label);

        // define the text field with an input mask
        JFormattedTextField textField = new JFormattedTextField();
        textField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        try {
            String inputMask = "HHHH-HHHH-HHHH";
            textField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(inputMask)));
        } catch (ParseException ex) {
            // will be raised if the inputMask cannot be parsed
            // add your own exception handling here
        }

        panel.add(textField);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}