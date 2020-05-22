public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            TicTacToe ttt = new TicTacToe();
            ttt.setVisible(true);
        }
    });
}