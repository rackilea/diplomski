public class Main {
    public static void main(String[] args) {
        final String text = args[0];
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final MyWindow wnd = new MyWindow(text);
                wnd.setVisible(true);
            }
        });
    }
}

public class MyWindow extends JFrame {
    public MyWindow(String text) {
        super("My Window");

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MyWindow.this.setVisible(false);
                MyWindow.this.dispose();
            }
        });

        final JButton btn = new JButton(text);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MyWindow.this, "Button Pressed", "Hey", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setLayout(new FlowLayout());
        add(btn);
        pack();
    }
}