for(Gun gun: guns) {
    final Bullet bullet = gun.shoot();
    if(bullet != null) {
        bullets.add(bullet);
    }
}