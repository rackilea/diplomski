boolean moveRight = false;
    Velocity vel = new Velocity();
    vel.x = 4;
    float movementSpeed = 3;

    while (vel.x !=  0) {
        if(moveRight && !(vel.x >= 3)) {
            vel.x += movementSpeed;
        }
        else if(vel.x >= 0 && !moveRight) {
            vel.x -= movementSpeed * 1.5f;
        }

        if (vel.x <= 0) {
            vel.x = 0;
        }

    }

    System.out.println(vel.x);