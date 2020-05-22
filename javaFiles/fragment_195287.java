public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        JLabel label = new JLabel(new CarIcon(40));
        JPanel panel = new JPanel();
        panel.add(label);
        JOptionPane.showMessageDialog(null, panel);
     }
  });
}