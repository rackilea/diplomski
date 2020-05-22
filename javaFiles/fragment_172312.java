public void removeBall() {
    if(comp.getBalls().size()>0){
        comp.getBalls().remove(0);
    }
    comp.repaint();
}