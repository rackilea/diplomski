frame.setIgnoreRepaint(true);
for (JButton lButton : components) {
                    // blink the buttons background on and off
    lButton.blink(on);
}
frame.setIgnoreRepaint(false);
frame.repaint();
on = !on;