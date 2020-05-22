public static void main(String args[]){

    JFrame contentPane = new JFrame();

    JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setBounds(23, 11, 50, 50);

    contentPane.add(scrollPane);

    JPanel panel = new JPanel();
    JLabel[] labels=new JLabel[8]; //callout.getRedCount() = 8
    panel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(0,10,0,0);
    int x = 50;
    int y = 50;
    for (int i=0;i<8;i++){ //callout.getRedCount() = 8
            labels[i]=new JLabel("Red" + i);
            gbc.gridx = i;
            panel.add(labels[i], gbc);
    }
    scrollPane.setViewportView(panel);
    contentPane.setSize(50,50);
    contentPane.setVisible(true);

}