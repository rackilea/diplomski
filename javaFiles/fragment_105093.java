public EventHandler implements ActionListener {
    int level_1_random_block;

    public EventHandler(int level_1_random_block) {
        this.level_1_random_block = level_1_random_block;    
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        if (level_1_random_block == 0){
                    source.setIcon(new        ImageIcon("C:\\Users\\Liam\\Desktop\\BOMB GAME\\oreDiamond.png"));
                    score += 100;
                    initialize_score();
                }
                if (level_1_random_block == 1){
                    source.setIcon(new ImageIcon("C:\\Users\\Liam\\Desktop\\BOMB GAME\\oreGold.png"));
                    score += 25;
                    initialize_score();
                }
                if (level_1_random_block == 2){
                    source.setIcon(new ImageIcon("C:\\Users\\Liam\\Desktop\\BOMB GAME\\oreGold.png"));
                    score += 25;
                    initialize_score();
                }
                if (level_1_random_block == 3){
                    source.setIcon(new ImageIcon("C:\\Users\\Liam\\Desktop\\BOMB GAME\\oreIron.png"));
                    score += 5;
                    initialize_score();
                }
                if (level_1_random_block == 4){
                    source.setIcon(new ImageIcon("C:\\Users\\Liam\\Desktop\\BOMB GAME\\oreIron.png"));
                    score += 5;
                    initialize_score();
                }

    }

}