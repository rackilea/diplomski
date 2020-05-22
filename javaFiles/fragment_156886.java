public void moveAndBounce() {
    x += speedX ;
    y += speedY ;

    Random random = new Random();
    if (touchHorizontalWall()) {
        if (speedX > 0) {

            // New speed between 10 and 15 (you can choose other)
            setSpeedX(-random.nextInt(15) + 10);
        } else {
            setSpeedX(random.nextInt(15) + 10
        }
    }
    if (touchVerticalWall()) {
        if (speedY > 0) {
            setSpeedY(-random.nextInt(15) + 10);
        } else {
            setSpeedY(random.nextInt(15) + 10);
        }
    }
}