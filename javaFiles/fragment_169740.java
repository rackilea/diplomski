public ReboundPanel() {
    // Other initializations ...

    addMouseListener(new ReboundMouseListener());    // <-- add

    timer.start();
}