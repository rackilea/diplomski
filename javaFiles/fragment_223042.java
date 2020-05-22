if(delta.x > 20f) {
        world.getPlayer().setVel(5.0f, 0f);
    } else {
        // Moves the player left
        if(delta.x < -20f) {
            world.getPlayer().setVel(-5.0f, 0);
        }
        // This is not being called
        else
            world.getPlayer().setVel(0f, 0f);
    }