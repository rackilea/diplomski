public void collision()
{
    Ship shipToRemove = null;
    Projectile projToRemove = null;

    outerLoop:
    for (Ship ship : Ship.ships) {
        for (Projectile proj : Projectile.projectiles) {
            if (ship.c != proj.c) {

                Rectangle.Float r1 = ship.getBounds();
                Rectangle.Float r2 = proj.getBounds();

                if (r1.intersects(r2)) {
                    shipToRemove = ship;
                    projToRemove = proj;
                    playSound();
                    break outerLoop;
                }
            }
        }
    }
    projALToRemove.add(projToRemove);
    shipALToRemove.add(shipToRemove);
}

public void update()
{

    for (Ship ship : Ship.ships) {
        ship.update(game);
    }
    for (Projectile proj : Projectile.projectiles) {
        proj.update(game);
    }
    deleteAfterCollision();
}

public void deleteAfterCollision()
{
    for (Ship ship : Ship.shipALToRemove) {
        Ship.ships.remove(ship);
    }
    for (Projectile proj : Ship.projALToRemove) {
        Projectile.projectiles.remove(proj);
    }
}