public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            JFrame f = new JFrame("Spider Web Plot");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new ChartPanel(prepareChart()));
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }
    });
}