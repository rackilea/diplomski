helper += speedVariable * delta;
xFromCenter = helper2 * MathUtils.cosDeg(helper));
yFromCenter = -1 * helper2 * MathUtils.sinDeg(helper));

setX(getCenterX() + xFromCenter + (Background.bg.getSpeedX() * 5));
setY(getCenterY() + yFromCenter);