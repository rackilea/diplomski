for (Area obstacle : obstacles) {
        if (doAreasCollide(obstacle, player)) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.GREEN);
        }
        g.fill(obstacle);
    }