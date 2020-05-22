public static void main(String[] args) {

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                String text = ((JButton) e.getSource()).getText();
                JOptionPane.showMessageDialog(null, text);
            }
        }
    };

    JPanel panel = new JPanel(new GridLayout(4,3));

    JButton[] array = new JButton[10];
    for (int i = 0; i < array.length; i++) {
        array[i] = new JButton(String.valueOf(i));
        array[i].addActionListener(listener);
        panel.add(array[i]);
    }

    JOptionPane.showMessageDialog(null, panel);

}