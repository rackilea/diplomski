if (moveHolder.size() > 0) {
    for (int i = 0; i < panelHolder.length; i++) {
        panelHolder[i] = moveHolder.get(moveHolder.size()-1)[i].clone();   
    }
    moveHolder.remove(moveHolder.size()-1);
}