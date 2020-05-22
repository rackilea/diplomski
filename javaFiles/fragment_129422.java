public class ButtonStateManager {

    private boolean mouseInTheHouse = false;
    private boolean timedOut = false;

    private JButton trigger;
    private JButton react;

    private Timer timer;

    public ButtonStateManager(JButton trigger, JButton react, int timeOut) {
        this.trigger = trigger;
        this.react = react;

        trigger.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                mouseInTheHouse = true;
                stateChanged();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseInTheHouse = false;
            }

        });

        Timer timer = new Timer(timeOut, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timedOut = true;
                stateChanged();
            }
        });
    }

    protected void stateChanged() {
        if (mouseInTheHouse && timedOut) {
            react.setBorder(TestPane.PANEL_BORDER);
        }
    }

}