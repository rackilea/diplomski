jButts[i].addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.getHSBColor(rand.nextFloat(),
                rand.nextFloat(), rand.nextFloat()));
    }
});