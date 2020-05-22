public class FieldAction extends JFrame {

    FieldAction() {

        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("###");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        final JFormattedTextField textField = new JFormattedTextField(mask);
        textField.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.out.println(textField.getText());
            }
        });

        add(textField, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new FieldAction();
    }
}