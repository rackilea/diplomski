trayIcon.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
        boolean someCondition = getUnknownConditionFromTheThreads();
        itemToDisable.setEnabled(someCondition);  // Reflected first time
    }
});