public void actionPerformed(ActionEvent ae) {
    Runnable task = new Runnable() {..};
    executor.execute(task);
    button.setIcon(newIcon);
    return;
}