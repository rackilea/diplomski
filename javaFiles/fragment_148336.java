public static void main(String args[]) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            // creating black background
            JFrame start = new JFrame("TatteredLands");
            start.getContentPane().setVisible(true);
            start.getContentPane().setBackground(Color.black);
            start.pack();
            start.setLocationRelativeTo(null);
            start.setVisible(true);
        }
    }
}