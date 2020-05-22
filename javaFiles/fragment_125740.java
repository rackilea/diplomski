public static void main(String[] args) {

    JTextField firstName = new JTextField();
    AbstractDocument d = (AbstractDocument) firstName.getDocument();
    d.setDocumentFilter(new DocumentSizeAndUppercaseFilter(10));

    JFrame frame = new JFrame("Test");
    frame.add(firstName);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 60);
    frame.setVisible(true);
}