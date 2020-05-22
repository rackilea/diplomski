public class TestPane extends JPanel {

    public TestPane() {

        Random rnd = new Random();

        JPanel panel = new JPanel();
        JPasswordField pf = new JPasswordField(10);
        JButton btn = new JButton("Login");
        panel.add(pf);
        panel.add(btn);

        panel.setBorder(new EmptyBorder(rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(10)));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(rnd.nextInt(100), rnd.nextInt(100), rnd.nextInt(100), rnd.nextInt(100));

        add(panel, gbc);

    }

}