int x = (totDist + posX) % imgPix; // NOTE: I am not sure what imgPix is or why you are modding the value by it.
int y = posY + foot;


if (x > 0 && x < actImg.getWidth() && y > 0 && y < actImg.getHeight()) {
    if (actImg.getImg().getRGB(x, y) == Color.WHITE.getRGB()) {
        posY += vy;
        vy += g;
        onGround = false;
    }
}