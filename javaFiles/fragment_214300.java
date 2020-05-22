private void tick() {
    if(left == true){
        if(x>=4){
            x-=4;
            }else{ x=0;}
            repaint();
        }
        if(right == true){
            if(x<=826){
                x+=4;
                }else{ x=830;}
            repaint();
        }
        if(up == true){
            if(y>=4){
            y-=4;
            }else{ y=0;}
            repaint();
        }
        if(down == true){
            if(y<=454){
            y+=4;
            }else{y=459;}
            repaint();
}