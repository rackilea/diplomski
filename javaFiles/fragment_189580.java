@Override
public void actionPerformed(ActionEvent e) {
    ...
    gscore--;
    if (gScore == 980) {
        ((Timer) e.getSource()).stop();
    }
}