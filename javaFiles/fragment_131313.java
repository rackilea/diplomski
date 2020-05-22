public class SlotMachine extends JFrame implements ActionListener {
    public static void main(String[] args) {
        SlotMachine mainFrame = new SlotMachine();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(640, 480);
        mainFrame.setLocationRelativeTo(null); // center on screen        
        mainFrame.setVisible(true);        
    }

    public SlotMachine() {
        setLayout(new BorderLayout());
        JButton button = new JButton("Open new window");
        button.setActionCommand("Add Credits");
        button.addActionListener(this);
        add(button, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String butonCommand = e.getActionCommand();
        if (butonCommand.equals("Add Credits")) {
            AddCreditsClass addCredits = new AddCreditsClass();
            addCredits.setLocationRelativeTo(this);
            addCredits.setVisible(true);
        }
    }
}