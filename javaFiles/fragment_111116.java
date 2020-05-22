button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String name = names[(int) (Math.random() * names.length)]; 
        ((JButton) e.getSource()).setText(name);
    }
});