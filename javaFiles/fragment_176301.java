timeSinceLastShot+=timeSinceLastFrame;

double bullet_angle = Math.atan2(MyMouseListener.getClickPosY()-posY, MyMouseListener.getClickPosX()-posX);
float bullet_startX = posX+(skin.getWidth()/2)-(Bullet.getImg().getWidth()/2);
float bullet_startY = posY+(skin.getHeight()/2)-(Bullet.getImg().getHeight()/2);
double bullet_speedX = Math.cos(bullet_angle)*500;
double bullet_speedY = Math.sin(bullet_angle)*500;

if(timeSinceLastShot>(1f/shotsPerSec) && MyMouseListener.isButtonClicked(MouseEvent.BUTTON1)){
    bullets.add(new Bullet(bullet_startX, bullet_startY, bullet_speedX, bullet_speedY));
    timeSinceLastShot = 0;
}