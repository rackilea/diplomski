Thread t = new Thread(new Runnable() {
    public void run() {
        JPanel visualizza = new JPanel();
        visualizza.add(new JLabel("Test", SwingConstants.CENTER));

        //display.add(visualizza, BorderLayout.SOUTH);

        updateProgress(visualizza);
    }
}