public void actionPerformed(ActionEvent e){


    if (e.getSource() instanceof (JButton)) {

        JButton button = (JButton) e.getSource();

        if(button.getText().equals("Start")){
            timer.start();
        }else
        if(button.getText().equals("Stop")){
            timer.stop();
        }else
        if(button.getText().equals("Circle")){
            shapes[count] = new Circle();
            drawPanel.repaint();
            count++;
        }


    }else (e.getSource() instanceof (Timer)) {
        //deal with timer
    }
}