public class Userinterface extends JPanel implements ActionListener {

    private final long serialVersionUID = 1L;
    private JTextField angle = new JTextField(5);
    private JLabel alabel = new JLabel("Angle");
    private JTextField velocity = new JTextField(5);
    private JLabel vlabel = new JLabel("Velocity");
    private JButton Actionbutton = new JButton("launch");
    private JTextField time = new JTextField(5);
    private JLabel tlabel = new JLabel("Time of fuse (s)");

    private FireworkModel model;

    Userinterface(FireworkModel model) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(time);
        add(tlabel);
        add(angle);
        add(alabel);
        add(velocity);
        add(vlabel);
        add(Actionbutton);
        Actionbutton.addActionListener(this);
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Actionbutton) {
            String str = angle.getText();
            String str2 = velocity.getText();
            String str3 = time.getText();
            int angle = Integer.parseInt(str);
            int velocity = Integer.parseInt(str2);
            int time = Integer.parseInt(str3);

            model.setAngle(angle);
            model.setVelocity(velocity);
            model.setTime(time);
        }
    }
}