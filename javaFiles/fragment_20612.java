class A extends JFrame {
    public static void main(String args[]) throws ParseException {
        A a = new A();
        a.setLayout(new GridLayout());
        JFormattedTextField textField =
                new JFormattedTextField(new MaskFormatter("####"));
        a.add(textField);
        a.add(new JButton("qwe"));
        a.setSize(300,50);
        a.setVisible(true);
    }
}