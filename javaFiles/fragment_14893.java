public class Test {

    JFrame mainFrame = new JFrame();
    JDialog instructions = new JDialog(mainFrame);

    public Test() {

        gui();
    }

    public void gui() {

        instructions.setSize(200, 200);

        JMenuBar mb = new JMenuBar();
        JMenu help = new JMenu("Help");
        mb.add(help);
        JMenuItem instructionsMenu = new JMenuItem("Instructions");
        help.add(instructionsMenu);
        instructionsMenu.addActionListener(e -> instructions.setVisible(true));

        mainFrame.setJMenuBar(mb);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Test());
    }
}