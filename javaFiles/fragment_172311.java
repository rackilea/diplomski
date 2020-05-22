public void changeBallSize(){
    if(Ball.getXSIZE()==15){
        Ball.setXSIZE(45);
    }else{
        Ball.setXSIZE(15);
    }
    if(Ball.getYSIZE()==15){
        Ball.setYSIZE(45);
    }else{
        Ball.setYSIZE(15);
    }

    Ball.setCircle(!Ball.isCircle());

    comp.repaint();
}