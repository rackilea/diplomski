newGame.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
         reset(iconPanel, icons);               <--- call reset method from below
         score = 0;
         scoreField.setText(String.valueOf(score));
    }
});
....

private void reset(JPanel panel, ImageIcon[] icons) {
    Component[] comps = panel.getComponents();
    Random random = new Random();
    for(Component c : comps) {
        if (c instanceof JLabel) {
            JLabel button = (JLabel)c;
            int index = random.nextInt(icons.length);
            button.setIcon(icons[index]);
        }
    }
}