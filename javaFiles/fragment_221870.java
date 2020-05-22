for(Iterator<Sprite> iterator = missiles.iterator(); iterator.hasNext();) {
        Sprite missile = iterator.next()
        missile.translateY(missileSpeed);
        if(missile.getY() <= 0) {
            iterator.remove();
        }
    }