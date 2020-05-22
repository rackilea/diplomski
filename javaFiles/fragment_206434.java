public class MainWindow extends JFrame{
    JPanel central;

    public MainWindow(){
        central = new JPanel();
        // I assume you define your other 5 panels here
        // and add them to the central JPanel.
        getContentPane().add(central, BorderLayout.CENTER);
        registerRefreshAction();
    }

    private void registerRefreshAction(){
        javax.swing.Action refresh = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame frame = (JFrame) getTopLevelAncestor();
                frame.setVisible(false);
                frame.getContentPane().repaint();
                frame.setVisible(true);
            }
        };
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0);
        central.getActionMap().put("Refresh", refresh);
        central.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "Refresh");
    }
}