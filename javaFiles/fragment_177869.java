JFrame frame = new JFrame();
final JPanel panel = new JPanel();
panel.setLayout(null);
final int size = 400;
javax.swing.Timer timer = new javax.swing.Timer(500, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel lab = new JLabel("HERE");
        lab.setLocation((int)(size * Math.random()), (int)(size * Math.random()));
        lab.setSize(new Dimension(40,20));
        panel.add(lab);
        panel.repaint();
    }
});

frame.add(panel);
frame.setSize(size, size);
frame.setVisible(true);
timer.start();