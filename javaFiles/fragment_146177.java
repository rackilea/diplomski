final Timer timer = new Timer(1000, null);
updateTask = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (pathIndex < path.size()) {
            update(pathIndex++);
        } else {
            timer.stop();
        }
        repaint();  // Refresh the JFrame, callback paintComponent()
    }
};
timer.addActionListener(updateTask);

add.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        pathIndex = 0;
        timer.start();
    }
});