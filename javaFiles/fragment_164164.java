private Knight knight;

public Room2(final Knight knight) {

    this.knight = knight;

    battlePanel.setLayout(new GridBagLayout());
    attack=new JButton("Attack");
    gb.gridx=1;
    gb.gridy=1;
    gb.insets=new Insets(10,10,10,10);
    attack.addActionListener(this);
    battlePanel.add(attack,gb);
    defend=new JButton("defend");
    gb.gridx=1;
    gb.gridy=2;
    battlePanel.add(defend,gb);

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==attack){
            knight.getHealth();
        }
    }
}