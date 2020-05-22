public Clicker(boolean visible) {

    buildGUI(visible);
    j = new Click(false).addPosition(new Point((Toolkit.getDefaultToolkit().getScreenSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height) / 2)).addPosition(new Point(getLocation().x + 1, getLocation().y + 20));
    // This is bad
    while (true) {

        j.runClicks(getDelay());
    }
}

public Clicker() {
    buildGUI(true);
    j = new Click(false).addPosition(new Point((Toolkit.getDefaultToolkit().getScreenSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height) / 2)).addPosition(new Point(getLocation().x + 1, getLocation().y + 20));
    // This is bad
    while (true) {

        j.runClicks(getDelay());
    }
}