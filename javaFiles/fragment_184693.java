if (input.isKeyDown(Input.KEY_RIGHT)) {
        dude = movingRight;
        dudePositionX -= delta * .1f;

        // Do these lines LATER after all the 
        //   controls of movement have been seen and the player updated
        if (dudePositionX < -840) { 
            dudePositionX += delta * .1f;
            // Instead of this line, you would have it be something like:
            // dudePositionX = previousDudePositionX;
        }
    }