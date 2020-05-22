public static void main(String[] args) throws InterruptedException {
    Runnable r = new Runnable() {
        @Override
        public void run() {
            JTextField jtx = new JTextField();
            jtx.setText("TEST");
            System.out.println("Before: " + jtx.getText());
            jtx.setEnabled(false);
            System.out.println("After: " + jtx.getText());
        }
    };
    SwingUtilities.invokeLater(r);
}