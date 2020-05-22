public static class ControlsPane extends JPanel {

    public static final String START_COMMAND = "Start";
    public static final String STOP_COMMAND = "Stop";

    private JButton start;
    private JButton stop;

    public ControlsPane() {
        start = new JButton(START_COMMAND);
        stop = new JButton(STOP_COMMAND);
        setLayout(new GridBagLayout());
        add(start);
        add(stop);
    }

    public void addActionListener(ActionListener listener) {
        start.addActionListener(listener);
        stop.addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        start.removeActionListener(listener);
        stop.removeActionListener(listener);
    }

}