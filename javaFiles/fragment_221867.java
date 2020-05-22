for(int i = bullets.size()-1; i >= 0; i--) {
        bullets.get(i).translateY(bulletSpeed);
        if(bullets.get(i).getY() >= Gdx.graphics.getHeight() + bullet.getHeight()) {
            bullets.remove(i);
        }
        for(int j = missiles.size()-1; j >= 0; j--) {
            if(missiles.get(j).getBoundingRectangle().overlaps(bullets.get(i).getBoundingRectangle())) {
                missiles.remove(j);
                bullets.remove(i);
            }
        }
    }