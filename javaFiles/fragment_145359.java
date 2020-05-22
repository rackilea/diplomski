Color color = Color.GREEN;
Timer timer;
public MyMap() {

    timer = null;
    timer = new Timer(5000, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            if (color.equals(Color.GREEN)) {
                color = Color.RED;
                timer.setDelay(2000);
            } else {
                color = Color.GREEN;
                timer.setDelay(8000);
            }
            repaint();
        }
    });
    timer.start();
}