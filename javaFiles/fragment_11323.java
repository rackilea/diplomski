for(Lifeform[] n : Life){
    for(Lifeform lf : n){
        g.setColor(lf.getColor());
        g.fillRect((int)lf.getX(), (int)lf.getY(), (int)lf.getWidth(), (int)lf.getHeight());
    }
}