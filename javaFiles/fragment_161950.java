JFrame frame = new JFrame();
JPanel content = new JPanel();
frame.setContentPane(content);
frame.getContentPane().setLayout(
        new BoxLayout(content, BoxLayout.Y_AXIS));
frame.setSize(400, 300);
GroupLayout gLayout = new GroupLayout(content);
content.setLayout(gLayout);
ParallelGroup hGroup = gLayout.createParallelGroup();
gLayout.setHorizontalGroup(hGroup);
SequentialGroup vGroup = gLayout.createSequentialGroup();
gLayout.setVerticalGroup(vGroup);
for (int i = 0; i < 3; i++) {
    JPanel panel = new JPanel();
    panel.add(new JLabel("label1"));
    panel.add(new JLabel("label2"));
    panel.add(new JLabel("label3"));
    panel.setBorder(BorderFactory.createLineBorder(Color.red));
    hGroup.addComponent(panel);
    vGroup.addComponent(panel, GroupLayout.PREFERRED_SIZE,
            GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
    vGroup.addGap(10);
}

frame.setVisible(true);