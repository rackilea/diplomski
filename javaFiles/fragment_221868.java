for(int i = missiles.size()-1; i >= 0; i--) {
        for(int j = bullets.size()-1; j >= 0; j--) {
            if(missiles.get(i).getBoundingRectangle().overlaps(bullets.get(j).getBoundingRectangle())) {
                missiles.remove(i);
                bullets.remove(j);
            }
        }
    }