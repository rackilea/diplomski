public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        JTextField textField1 = new JTextField(30);
        JTextField textField2 = new JTextField(30);
        JTextField textField3 = new JTextField(30);
        JButton jButton = new JButton("Button");

        ButtonModel model = jButton.getModel();
        Document document1 = textField1.getDocument();
        Document document2 = textField2.getDocument();
        Document document3 = textField3.getDocument();

        ButtonEnablement buttonEnablement = new ButtonEnablement(model);
        buttonEnablement.addDocument(document1);
        buttonEnablement.addDocument(document2);
        buttonEnablement.addDocument(document3);

        contentPane.add(textField1);
        contentPane.add(textField2);
        contentPane.add(textField3);
        contentPane.add(jButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}