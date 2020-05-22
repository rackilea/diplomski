public class ListenerCasillas implements ActionListener {
    JPanel panel;

    ListenerCasillas(JPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.removeAll();
        panel.setBackground(Color.green);
        panel.add(new JLabel("1"));
        panel.revalidate();
        panel.repaint();
    }
}