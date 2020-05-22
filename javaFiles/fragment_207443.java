public void shoot() {
        if (shot == true) {
            by = by - 2; //this is fine, it moves the bullet up
        }
        if (by <= -5) {
            //Resetting values
            bx = x + 32;
            by = y - 15;
            bullet = new Rectangle(bx, by, 10, 10);
            shot = false;
        }
    }