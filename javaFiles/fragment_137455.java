ActionListener listener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hello World!");
    }
};

// Using the listener with 2 seconds delay
java.swing.Timer timer = new java.swing.Timer(2000, listener);
timer.setRepeats(false);

// Start the timer
timer.start();