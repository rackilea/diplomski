class ... implements MouseMotionListener {
    //...

    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        int hudX = Game.WIDTH / 2 - 285;
        int hudY = Game.HEIGHT / 2 - 170;
        int hudW = Game.hud.materials[1].getWidth();
        int hudH = Game.hud.materials[1].getHeight();
        isOnMaterial[0] = mouseOver(mx, my, hudX, hudY, hudW, hudH);
    }
}