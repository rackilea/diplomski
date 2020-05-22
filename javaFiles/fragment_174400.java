@SuppressWarnings("serial")
class Frame2 extends JFrame {
    public static final String FRAME_STATE = "frame state";
    private static final Dimension PANEL_SIZE = new Dimension(640, 400);
    private JLabel frameStateLabel = new JLabel("1");
    private int frameState = 1;    

    public Frame2() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JButton next = new JButton("Next");
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(PANEL_SIZE);
        panel.setBackground(new Color(245, 252, 255));
        panel.add(next);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Frame State: "));
        panel.add(frameStateLabel);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frameState > 3) {
                    setFrameState(1);  // ***Always*** change frameState by the setter method
                } else {
                    setFrameState(frameState + 1);  // ** Ditto **
                }       
            }
        });

        add(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }   

    public int getFrameState() {
        return frameState;
    }

    public void setFrameState(int frameState) {
        int oldValue = this.frameState;
        int newValue = frameState;
        this.frameState = frameState;
        firePropertyChange(FRAME_STATE, oldValue, newValue);
        frameStateLabel.setText("" + frameState);
    }
}