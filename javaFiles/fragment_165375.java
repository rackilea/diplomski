private void mover(JLabel label,boolean inv,boolean y){

    final int delta = inv ? -1 :1 , deltax =  y ? 1: 0, timesq = 40;

    ActionListener moveX = new ActionListener() {

        int counterX = timesq, counterY = timesq;

        @Override
        public void actionPerformed(ActionEvent e) {

            if(--counterX > 0){ //move at x direction 
                int x = label.getX() + delta;
                label.setLocation(x, label.getY());
                label.setText(String.valueOf(x));
            }else if(--counterY > 0){ //move at y direction
                int y1 = label.getY() + deltax;
                label.setLocation(label.getX(), y1);
                label.setText(String.valueOf(y1));
            }else{
                Timer timer = (Timer)e.getSource();
                timer.stop();
            }
            repaint();
        }
    };

    Timer timer = new Timer(20,moveX);
    timer.start();
}