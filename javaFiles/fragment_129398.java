public class UI extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout blayout = new BorderLayout();
        JButton center = new JButton();
        JButton north = new JButton();
        JButton south = new JButton();
        south.addActionListener(e->{System.out.println("Save button is pressed");});
        JComboBox combo = new JComboBox();
        combo.addItem("-");
        combo.addItem("Tehran");
        combo.addItem("Tabriz");
        combo.addItem("Shiraz");
        combo.addActionListener(e -> {
            System.out.println(((JComboBox<String>) e.getSource()).getSelectedItem());
        });
        JRadioButton rb1 = new JRadioButton("man");
        rb1.addActionListener(e -> {
            System.out.println("man: " + ((JRadioButton) e.getSource()).isSelected());
        });
        JRadioButton rb2 = new JRadioButton("weman");
        rb2.addActionListener(e -> {
            System.out.println("weman: " + ((JRadioButton) e.getSource()).isSelected());
        });
        frame.setLayout(blayout);
        FlowLayout fLoyout = new FlowLayout(FlowLayout.CENTER);
        center.setLayout(fLoyout);
        south.setLayout(fLoyout);
        JLabel jb1 = new JLabel("Name :");
        JTextField name = new JTextField(20);
        center.add(jb1);
        center.add(name);
        name.addActionListener(e -> {
            System.out.println("name: " + ((JTextField) e.getSource()).getText());
        });
        JLabel jb2 = new JLabel("Family :");
        JTextField family = new JTextField(20);
        center.add(jb2);
        center.add(family);
        family.addActionListener(e -> {
            System.out.println("family: " + ((JTextField) e.getSource()).getText());
        });
        JLabel jb4 = new JLabel("City :");
        center.add(jb4);
        center.add(combo);
        JLabel jb5 = new JLabel("Sex :");
        center.add(jb5);
        center.add(rb1);
        center.add(rb2);
        JLabel jb6 = new JLabel("Comment :");
        JTextField comment = new JTextField(50);
        comment.addActionListener(e -> {
            System.out.println("comment: " + ((JTextField) e.getSource()).getText());
        });
        JLabel jb7 = new JLabel("Save");
        south.add(jb7);
        JPanel cpanel = new JPanel();
        cpanel.add(center);
        JPanel spanel = new JPanel();
        spanel.add(south);
        cpanel.setLayout(new BoxLayout(cpanel, BoxLayout.Y_AXIS));
        cpanel.add(jb6);
        cpanel.add(comment);
        frame.add(cpanel, BorderLayout.CENTER);
        frame.add(spanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}