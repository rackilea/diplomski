public static void main(String[] args){
    JFrame frame = new JFrame("Up Up And Away!");
    JComponent star = new Test2("*", 250, 100);
    frame.add(star);
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    star.grabFocus();
}