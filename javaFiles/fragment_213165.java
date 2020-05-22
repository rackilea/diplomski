private static void runClient() {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            String[] args1={"10"};
            ClientMain.main(args1);
        }
    });
}