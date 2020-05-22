public class GridBagTest{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GridBagTest();
            }
        });
    }

    public GridBagTest(){
        JButton atk, mag, fort, pot1, pot2, flee;
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridBagLayout());

        JFrame gameFrame = new JFrame("FightQuest"); 
        gameFrame.getContentPane().add(gamePanel);
        gameFrame.setSize(800, 600);


        atk = new JButton("Strike");
        mag = new JButton("Magic");
        fort = new JButton("Fortify");
        pot1 = new JButton("Potion 1");
        pot2 = new JButton("Potion 2");
        flee = new JButton("Flee");
        addItem(gamePanel, atk, 0, 0, 1, 1, GridBagConstraints.SOUTHEAST);
        addItem(gamePanel, mag, 1, 0, 1, 1, GridBagConstraints.SOUTH);
        addItem(gamePanel, fort, 2, 0, 1, 1, GridBagConstraints.SOUTHWEST);
        addItem(gamePanel, pot1, 0, 1, 1, 1, GridBagConstraints.NORTHEAST);
        addItem(gamePanel, pot2, 1, 1, 1, 1, GridBagConstraints.NORTH);
        addItem(gamePanel, flee, 2, 1, 1, 1, GridBagConstraints.NORTHWEST);
        gameFrame.pack();
        gameFrame.setVisible(true);

    }

    private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align){
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }
}