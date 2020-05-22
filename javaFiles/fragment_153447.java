public class MouseEvtEx2 extends JFrame implements MouseListener {
    private JTextArea txtArea;

    public MouseEvtEx2(String title) {
        super(title);
        Panel p1 = new Panel();
        MyPanel panelTop = new MyPanel();
        panelTop.setBackground(new Color(0.98f, 0.97f, 0.85f));
        panelTop.setOpaque(true);
        panelTop.setPreferredSize(new Dimension(400, 200));
        panelTop.setBorder(BorderFactory.createRaisedBevelBorder());

        getContentPane().add(panelTop);
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        JScrollPane pane = new JScrollPane(txtArea);
        pane.setPreferredSize(new Dimension(400, 200));
        p1.setLayout(new GridLayout(2, 1, 0, 0));
        getContentPane().add(p1);
        p1.addMouseListener(this);
        p1.add(pane);

        // txtArea.setText
        // revalidate();
        setSize(600, 600);
        show();
    }

    public void record(String st, MouseEvent et) {
        txtArea.setText("" + st + "" + et.toString());
    }// setVisible(true);}

    public void mouseClicked(MouseEvent evt) {
        record("Mouse clicked # of mouse clicks: " + evt.getClickCount(), evt);// +
                                                                                // " "
                                                                                // +

    }

    public void mouseEntered(MouseEvent evt) {
        record("Mouse entered ", evt);// .toString());
    }

    public void mouseExited(MouseEvent evt) {
        record("Mouse exited ", evt);// .toString());
    }

    public void mousePressed(MouseEvent evt) {
        record("Mouse pressed # of mouse clicks: ", evt);// .getClickCount() +
                                                            // " " +

    }

    public void mouseReleased(MouseEvent evt) {
        record("Mouse released ", evt);
    }

    public static void main(String[] args) {
        new MouseEvtEx2("Mouse events");
    }
}