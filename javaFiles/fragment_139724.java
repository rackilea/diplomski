public void shoot() {

    if (shot) {
        bullet.y--;
        // Have we past the edge of the screen
        if (bullet.y < 0) {
            shot = false;
            bullet = null;
        }
    }

}