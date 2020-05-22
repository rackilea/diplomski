public class PopupTest2 {
    public static void main(String[] a) {
        final JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel(new BorderLayout());

        final JPopupMenu menu = new JPopupMenu();

        final JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));

        final JMenuItem[] items = new JMenuItem[1];
        for (int i = 0; i < 1; i++) {
            JMenuItem item = new JMenuItem("Item #"+String.valueOf(i));
            itemPanel.add(item);
            items[i] = item;
        }
        menu.updateUI();

        menu.add(itemPanel);

        JToggleButton button = new JToggleButton("Press me");
        button.addActionListener(new ActionListener() {
            boolean pressed = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                pressed = !pressed;
                if (pressed) {
                    for (JMenuItem item : items) {
                        item.setText(item.getText()+" changed");
                    }
                } else {
                    for (JMenuItem item : items) {
                        item.setText(item.getText().substring(0, item.getText().length() - 8));
                    }
                }
            }
        });

        panel.add(button, BorderLayout.NORTH);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    MenuItemLayoutHelper.clearUsedClientProperties(itemPanel);
                    itemPanel.revalidate();
                    menu.show(panel, (int) (e.getX() - menu.getPreferredSize().getWidth()), e.getY());
                }
            }
        });
        frame.setContentPane(panel);
        frame.setUndecorated(true);
        frame.setBackground(new Color(50, 50, 50, 200));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }
}