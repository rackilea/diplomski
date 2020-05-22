//...
private Timer timer;
//...

JButton button = new JButton("Start");
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (timer == null) {
            timer = new Timer(100, new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    shape.translate(x, y);
                    label.repaint();
                }
            });
            timer.start();
            button.setText("Pause");
        } else if (timer.isRunning()) {
            timer.stop();
            button.setText("Resume");
        } else {
            timer.start();
            button.setText("Pause");
        }
    }
});