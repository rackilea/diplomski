import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuExample {
    private JFrame frame;
    private JLabel choiceIndicator;

    MenuExample create() {
        frame = createFrame();
        choiceIndicator = new JLabel();
        frame.setJMenuBar(createMenuBar());
        frame.getContentPane().add(createContent());

        return this;
    }

    private Component createContent() {
        JPanel panel = new JPanel();

        panel.add(new JLabel("Last menu item choice:"));
        panel.add(choiceIndicator);

        return panel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createWorld());
        return menuBar;
    }

    private JMenu createWorld() {
        JMenu worldMenu = new JMenu("World");

        worldMenu.add(createIndia());
        worldMenu.add(new JMenu("Australia"));
        worldMenu.add(new JMenu("America"));

        return worldMenu;
    }

    private JMenu createIndia() {
        JMenu india = new JMenu("India");

        india.add(createOdisha());
        india.add(new JMenu("Delhi"));
        india.add(new JMenu("Uttar Pradesh"));
        india.add(new JMenu("Madhya Pradesh"));

        return india;
    }

    private JMenuItem createOdisha() {
        JMenu menu = new JMenu("Odisha");

        menu.add(createBhubaneswar());
        menu.add(new JMenu("Berhampur"));

        return menu;
    }

    private JMenuItem createBhubaneswar() {
        JMenu menu = new JMenu("Bhubaneswar");
        menu.add(choiceItem("Raj Mahal"));
        menu.add(choiceItem("Acharya Bihar"));
        menu.add(choiceItem("Bani Bihar"));

        return menu;
    }

    private JMenuItem choiceItem(String text) {
        return new JMenuItem(new Choice(text, choiceIndicator));
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame(getClass().getSimpleName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame;
    }

    void show() {
        frame.setSize(350, 250);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuExample().create().show();
            }
        });
    }

    class Choice extends AbstractAction {
        private final JLabel choiceIndicator;

        public Choice(String text, JLabel choiceIndicator) {
            this(text, null, null, null, choiceIndicator);
        }

        public Choice(String text, ImageIcon icon, String desc, Integer mnemonic, JLabel choiceIndicator) {
            super(text, icon);
            putValue(SHORT_DESCRIPTION, desc);
            putValue(MNEMONIC_KEY, mnemonic);

            this.choiceIndicator = choiceIndicator;
        }

        public void actionPerformed(ActionEvent e) {
            choiceIndicator.setText(e.getActionCommand());
        }
    }
}