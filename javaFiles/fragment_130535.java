@Override
public void mouseClicked(MouseEvent e) {
    /*
     * Selecting color
     */
    if(e.getX()>0 && e.getX()=<(cwidth)){
        c=Color.BLACK;
        System.out.println("BLACK");

    }
    else if(e.getX()>(cwidth) && x1=< (cwidth*2) ){
        c=Color.RED;
        System.out.println("RED");
    }
    else if(e.getX()>(cwidth*2) && x1=< (cwidth*3)){
        c=Color.GREEN;
        System.out.println("GREEN");

    }
    else if(e.getX()>(cwidth*3) && x1=< (cwidth*4)){
        c=Color.BLUE;
        System.out.println("BLUE");

    }