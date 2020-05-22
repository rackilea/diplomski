public static void main(String [] arg) {
    Class1 cls = new Class1();

    cls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // cls.setVisible(true); // *** removed
    cls.createGUI();
    cls.setVisible(true); // *** added
}