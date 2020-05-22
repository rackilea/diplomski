EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {
            SignInFrame frame = new SignInFrame();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});