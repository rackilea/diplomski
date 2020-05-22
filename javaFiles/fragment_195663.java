...
    label3.setText(u2 + " CPS");
    label1.setText(" " + c);
    c = c + u2;
    timer = new Timer(1000, this);       // Start a new timer that calls
    timer.start();                       // actionPerformed when it expires.
} else if (ae.getSource() == timer) {    // Handle timer events
    if (u2 >= 1) {
        c = c + u2;
        label1.setText(" " + c);
        timer.start();                   // Restart the timer
    }
}