tooltipTimer = new Timer(100, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (currTree.getMousePosition() == null) {
            hideDropTooltip();
        } else {
            tooltipTimer.restart();
        }                    
    }
});