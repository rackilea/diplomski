intextArea.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override public void keyReleased(java.awt.event.KeyEvent e) {
        String command = intextArea.getText();
        if (!command.contains("=")) {
            return;
        }

        command = command.substring(0, command.length() - 1);
        if (command.equals("exit")) {
            frame.setVisible(false);
            frame.dispose();
            return;
        }
        outtextArea.append(command + "\n");
        intextArea.setText("");
    }
});