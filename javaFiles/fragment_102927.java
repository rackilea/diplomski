public void mouseMoved(MouseEvent e) {
    mouseX = e.getX();
    mouseY = e.getY();
    if(mouseX > 699 && mouseX < 761 && mouseY > 22 + 25 && mouseY < 54 + 25){
        settingsConfig = "/assets/settingshover.png";
    }
    else{
        settingsConfig = "/assets/settings.png";
    }
    repaint();  
}