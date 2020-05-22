// fire every 500 ms
private static long INTERVAL = 500;
private long mLastFiredTime;
private void addBullets()//элементы для анимации заднего плана
{
    if(gettouch)
    {
         long now = System.currentTimeMillis();
         if (now > mLastFiredTime + INTERVAL) {
             mBullets.add(new Bullet(mBulletImage, touchedX, touchedY, 22, 52, 3, 3));
             mLastFiredTime = now;
         }
    }
}