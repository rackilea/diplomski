SwingUtilities.invokeLater(new Runnable() {

    @Override
    public void run() {
        JameSimpsonP7 panel = new JameSimpsonP7();
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
});