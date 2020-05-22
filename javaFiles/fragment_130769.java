public class MyFrame extends JFrame {

    public MyFrame() {
        ButtonGroup bg = new ButtonGroup();
        JRadioButton b1 = new JRadioButton("My Button 1");
        JRadioButton b2 = new JRadioButton("My Button 2");
        bg.add(b1);
        bg.add(b2);

        BoxLayout bl = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(bl);

        b1.setAlignmentX(CENTER_ALIGNMENT);
        b2.setAlignmentX(CENTER_ALIGNMENT);

        this.add(b1);
        this.add(b2);
    }

}