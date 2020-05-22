@Override
    public void actionPerformed(ActionEvent e) {
        button = (JButton) e.getSource();

        if (button.equals(leftButton)) {
            removeFromQueue();
            **queue.getSelectionModel().clearSelection();**
        } else if (button.equals(rightButton)) {
            addToQueue();
            **list.getSelectionModel().clearSelection();**
        }
    }