public static void main (String[] args) {

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    MedForm medForm = new MedForm();
    frame.setContentPane(medForm);

    frame.setBounds(200, 200, 600, 600);
    frame.setVisible(true);
}